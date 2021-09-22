/*
 * Copyright (c) 2021 Fraunhofer-Gesellschaft zur Foerderung der angewandten Forschung e. V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.adminshell.aas.v3.model.validator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import io.adminshell.aas.v3.model.AssetAdministrationShellEnvironment;
import io.adminshell.aas.v3.model.ConceptDescription;
import io.adminshell.aas.v3.model.DataSpecificationIEC61360;
import io.adminshell.aas.v3.model.DataTypeIEC61360;
import io.adminshell.aas.v3.model.EmbeddedDataSpecification;
import io.adminshell.aas.v3.model.IdentifierType;
import io.adminshell.aas.v3.model.Key;
import io.adminshell.aas.v3.model.KeyElements;
import io.adminshell.aas.v3.model.KeyType;
import io.adminshell.aas.v3.model.LangString;
import io.adminshell.aas.v3.model.MultiLanguageProperty;
import io.adminshell.aas.v3.model.Reference;
import io.adminshell.aas.v3.model.Submodel;
import io.adminshell.aas.v3.model.impl.DefaultDataSpecificationIEC61360;
import io.adminshell.aas.v3.model.impl.DefaultEmbeddedDataSpecification;
import io.adminshell.aas.v3.model.impl.DefaultIdentifier;
import io.adminshell.aas.v3.model.impl.DefaultKey;
import io.adminshell.aas.v3.model.impl.DefaultMultiLanguageProperty;
import io.adminshell.aas.v3.model.impl.DefaultReference;
import io.adminshell.aas.v3.model.impl.DefaultSubmodel;
import io.adminshell.aas.v3.model.impl.DefaultValueList;
import io.adminshell.aas.v3.model.impl.DefaultValueReferencePair;

/**
 * Tests the following constraint:
 * <p>
 * <i> If the semanticId of a MultiLanguageProperty or MultiLanguageMultiLanguageProperty references a ConceptDescription with the category MultiLanguageProperty and DataSpecificationIEC61360/valueList is defined the value and valueId of the MultiLanguageProperty is identical to one of the value reference pair types references in the value list,
 * i.e. ValueReferencePairType/value or ValueReferencePairType/valueId, resp. </i>
 * </p>
 *
 * @author bader, chang
 *
 */

public class TestAASd_66a {

    @Test
    @Ignore
    public void wrongValueReferencePairTypesValue() throws ValidationException {
        Reference multilanguageValueIdReference = new DefaultReference.Builder()
                .key(new DefaultKey.Builder()
                        .idType(KeyType.CUSTOM)
                        .value("This is the MultiLanguagePropertyReferenceKeyValue ")
                        .type(KeyElements.GLOBAL_REFERENCE)
                        .build())
                .build();


        DataSpecificationIEC61360 ds = new DefaultDataSpecificationIEC61360.Builder()
                .valueList(new DefaultValueList.Builder()
                        .valueReferencePairTypes(new DefaultValueReferencePair.Builder()
                                .value("This is not identical to Multilanguage property value.")
                                .valueId(multilanguageValueIdReference)
                                .build())
                        .build())
                .build();

        EmbeddedDataSpecification embeddedDataSpecification = new DefaultEmbeddedDataSpecification.Builder()
                .dataSpecificationContent(ds)
                .dataSpecification( ConstraintTestHelper.createDummyReference() )
                .build();

        ConceptDescription cd = ConstraintTestHelper.createConceptDescription("Concept-Description", "http://example.org/MultilanguageCD", "constant");
        cd.setCategory("PROPERTY");
        cd.setEmbeddedDataSpecifications(new ArrayList<>(){{ add(embeddedDataSpecification) ; }} );

        Reference semanticIdReference = ConstraintTestHelper.createDummyReference();
        Key key = semanticIdReference.getKeys().get(0);
        key.setIdType(KeyType.IRI);
        key.setType(KeyElements.CONCEPT_DESCRIPTION);
        key.setValue(cd.getIdentification().getIdentifier());

        MultiLanguageProperty property = new DefaultMultiLanguageProperty.Builder()
                .idShort("idShort")
                .value(new LangString("This is the value of MultilanguageProperty", "en"))
                .valueId(multilanguageValueIdReference)
                .semanticId(semanticIdReference)
                .build();

        Submodel submodel = new DefaultSubmodel.Builder()
                .idShort("submodel_idShort")
                .identification(new DefaultIdentifier.Builder().identifier("http://example.org/TestSubmodel").idType(IdentifierType.IRI).build())
                .submodelElements(new ArrayList<>() {{add(property);}})
                .build();

        AssetAdministrationShellEnvironment wrongAssetAdministrationShellEnvironment = ConstraintTestHelper
                .createEnvironment(
                        submodel,
                        new ArrayList<>() {{add(cd);}}
                );


        try {
            ShaclValidator.getInstance().validate(wrongAssetAdministrationShellEnvironment);
            fail();
        } catch (ValidationException e) {
            assertTrue(e.getMessage().endsWith(
                    "If the semanticId of a MultiLanguageProperty or MultiLanguageMultiLanguageProperty references a ConceptDescription with the category MultiLanguageProperty and DataSpecificationIEC61360/valueList is defined the value and valueId of the MultiLanguageProperty is identical to one of the value reference pair types references in the value list, i.e. ValueReferencePairType/value or ValueReferencePairType/valueId, resp."));
        }

    }

    @Test
    public void correctConceptDescriptionDatatype() throws ValidationException {
        Reference reference = new DefaultReference.Builder()
                .key(new DefaultKey.Builder()
                        .idType(KeyType.CUSTOM)
                        .value("1234")
                        .type(KeyElements.GLOBAL_REFERENCE)
                        .build())
                .build();

        DataSpecificationIEC61360 ds = new DefaultDataSpecificationIEC61360.Builder()
                .dataType(DataTypeIEC61360.STRING_TRANSLATABLE) // This should be DataTypeIEC61360.STRING_TRANSLATABLE
                .preferredName(new LangString("Data Specification", "en"))
                .definition(new LangString("A definition of a STRING_TRANSLATABLE in English.", "en"))
                .valueList(new DefaultValueList.Builder()
                        .valueReferencePairTypes(new DefaultValueReferencePair.Builder()
                                .value("Multilanguage")
                                .valueId(reference)
                                .build())
                        .build())
                .build();

        EmbeddedDataSpecification embeddedDataSpecification = new DefaultEmbeddedDataSpecification.Builder()
                .dataSpecificationContent(ds)
                .dataSpecification( ConstraintTestHelper.createDummyReference() )
                .build();

        ConceptDescription cd = ConstraintTestHelper.createConceptDescription("Concept-Description", "http://example.org/MultilanguageCD", "constant");
        cd.setCategory("PROPERTY");
        cd.setEmbeddedDataSpecifications(new ArrayList<>(){{ add(embeddedDataSpecification) ; }} );

        Reference dummyReference = ConstraintTestHelper.createDummyReference();
        Key key = dummyReference.getKeys().get(0);
        key.setIdType(KeyType.IRI);
        key.setType(KeyElements.CONCEPT_DESCRIPTION);
        key.setValue(cd.getIdentification().getIdentifier());

        MultiLanguageProperty property = new DefaultMultiLanguageProperty.Builder()
                .idShort("idShort")
                .value(new LangString("Multilanguage", "en"))
                .valueId(reference)
                .semanticId(dummyReference)
                .build();

        Submodel submodel = new DefaultSubmodel.Builder()
                .idShort("submodel_idShort")
                .identification(new DefaultIdentifier.Builder().identifier("http://example.org/TestSubmodel").idType(IdentifierType.IRI).build())
                .submodelElements(new ArrayList<>() {{add(property);}})
                .build();

        AssetAdministrationShellEnvironment assetAdministrationShellEnvironment = ConstraintTestHelper
                .createEnvironment(
                        submodel,
                        new ArrayList<>() {{add(cd);}}
                );


        ShaclValidator.getInstance().validate(assetAdministrationShellEnvironment);

    }
}
