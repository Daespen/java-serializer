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
package io.adminshell.aas.v3.dataformat.json;

import io.adminshell.aas.v3.dataformat.SerializationException;
import io.adminshell.aas.v3.model.*;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class JsonReferableSerializerTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonReferableSerializerTest.class);

    @Test
    public void testSerializeAAS() throws IOException, SerializationException, JSONException {
        AssetAdministrationShellEnvironment environment = AASFull.ENVIRONMENT;
        AssetAdministrationShell assetAdministrationShell = environment.getAssetAdministrationShells().get(0);
        validateAndCompare("src/test/resources/assetAdministrationShell.json",assetAdministrationShell);
    }

    @Test
    public void testSerializeMultipleAAS() throws IOException, SerializationException, JSONException {
        AssetAdministrationShellEnvironment environment = AASFull.ENVIRONMENT;
        validateAndCompare("src/test/resources/assetAdministrationShellList.json",
                environment.getAssetAdministrationShells().get(0), environment.getAssetAdministrationShells().get(1));
    }

    @Test
    public void testSerializeSubmodel() throws IOException, SerializationException, JSONException {
        AssetAdministrationShellEnvironment environment = AASFull.ENVIRONMENT;
        Submodel submodel = environment.getSubmodels().get(0);
        validateAndCompare("src/test/resources/submodel.json",submodel);
    }

    @Test
    public void testSerializeMultipleSubmodels() throws IOException, SerializationException, JSONException {
        AssetAdministrationShellEnvironment environment = AASFull.ENVIRONMENT;
        validateAndCompare("src/test/resources/submodelList.json", environment.getSubmodels().get(0), environment.getSubmodels().get(1));
    }

    @Test
    public void testSerializeSubmodelelement() throws IOException, SerializationException, JSONException {
        AssetAdministrationShellEnvironment environment = AASFull.ENVIRONMENT;
        SubmodelElement submodelElement = environment.getSubmodels().get(0).getSubmodelElements().get(0);
        validateAndCompare("src/test/resources/submodelElement.json",submodelElement);
    }

    @Test
    public void testSerializeMultipleSubmodelelements() throws IOException, SerializationException, JSONException {
        AssetAdministrationShellEnvironment environment = AASFull.ENVIRONMENT;
        SubmodelElement submodelElement0 = environment.getSubmodels().get(0).getSubmodelElements().get(0);
        SubmodelElement submodelElement1 = environment.getSubmodels().get(0).getSubmodelElements().get(1);
        validateAndCompare("src/test/resources/submodelElementList.json",submodelElement0,submodelElement1);
    }

    @Test
    public void testSerializeSubmodelelementCollection() throws IOException, SerializationException, JSONException {
        AssetAdministrationShellEnvironment environment = AASFull.ENVIRONMENT;
        SubmodelElement submodelElementCollection = environment.getSubmodels().get(6).getSubmodelElements().get(5);
        validateAndCompare("src/test/resources/submodelElementCollection.json",submodelElementCollection);
    }

    private void validateAndCompare(String filePathForExpected, Referable... referable) throws IOException, SerializationException, JSONException {
        File fileExpected = new File(filePathForExpected);
        String expected = Files.readString(fileExpected.toPath());
        String actual;
        if(referable.length>1){
            actual = new JsonSerializer().write(List.of(referable));
        } else {
            actual = new JsonSerializer().write(Arrays.stream(referable).findFirst().get());
        }
        logger.info(actual);

        JSONAssert.assertEquals(expected, actual, JSONCompareMode.NON_EXTENSIBLE);
        JSONAssert.assertEquals(actual, expected, JSONCompareMode.NON_EXTENSIBLE);

    }

}
