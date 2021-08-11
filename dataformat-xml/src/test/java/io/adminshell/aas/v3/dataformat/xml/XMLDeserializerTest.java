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
package io.adminshell.aas.v3.dataformat.xml;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

import io.adminshell.aas.v3.dataformat.DeserializationException;
import io.adminshell.aas.v3.dataformat.model.AASFull;
import io.adminshell.aas.v3.dataformat.model.AASSimple;
import io.adminshell.aas.v3.model.AssetAdministrationShellEnvironment;

public class XMLDeserializerTest {
    public static final java.io.File AASFULL_FILE = XmlSerializerTest.AASFULL_FILE;
    public static final java.io.File AASSIMPLE_FILE = XmlSerializerTest.AASSIMPLE_FILE;

    @Test
    public void deserializeAASSimple() throws Exception {
        AssetAdministrationShellEnvironment env = new XmlDeserializer().read(AASSIMPLE_FILE);
        assertEquals(AASSimple.ENVIRONMENT.getAssetAdministrationShells(), env.getAssetAdministrationShells());
        System.out.println(new XmlSerializer().write(AASSimple.ENVIRONMENT));
        Object a = AASSimple.ENVIRONMENT.getConceptDescriptions().get(0);
        Object b = env.getConceptDescriptions().get(0);
        assertEquals(a, b);
        assertEquals(AASSimple.ENVIRONMENT.getConceptDescriptions().get(1), env.getConceptDescriptions().get(1));
        assertEquals(AASSimple.ENVIRONMENT.getConceptDescriptions().get(2), env.getConceptDescriptions().get(2));
        assertEquals(AASSimple.ENVIRONMENT.getConceptDescriptions(), env.getConceptDescriptions());
        assertEquals(AASSimple.ENVIRONMENT.getSubmodels(), env.getSubmodels());
        assertEquals(AASSimple.ENVIRONMENT, env);
    }

    @Test
    public void deserializeAASFull() throws FileNotFoundException, DeserializationException {
        AssetAdministrationShellEnvironment env = new XmlDeserializer().read(AASFULL_FILE);
        assertEquals(AASFull.ENVIRONMENT, env);
    }
}
