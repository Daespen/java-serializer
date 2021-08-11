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
package io.adminshell.aas.v3.dataformat.aasx.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Before;
import org.junit.Test;

import io.adminshell.aas.v3.dataformat.AASSimple;
import io.adminshell.aas.v3.dataformat.SerializationException;
import io.adminshell.aas.v3.dataformat.aasx.AASXSerializer;
import io.adminshell.aas.v3.dataformat.aasx.InMemoryFile;

public class AASXSerializerTest {

    private static final String XML_PATH = "aasx/xml/content.xml";
    private static final String ORIGIN_PATH = "aasx/aasx-origin";

    private List<InMemoryFile> fileList = new ArrayList<>();

    @Before
    public void setup() throws IOException {
        byte[] operationManualContent = {0, 1, 2, 3, 4};
        InMemoryFile file = new InMemoryFile(operationManualContent, "aasx/OperatingManual.pdf");
        fileList.add(file);
    }

    @Test
    public void testBuildAASX() throws IOException, TransformerException, ParserConfigurationException, SerializationException {

        // This stream can be used to write the .aasx directly to a file
        // FileOutputStream out = new FileOutputStream("path/to/test.aasx");

        // This stream keeps the output of the AASXFactory only in memory
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        new AASXSerializer().write(AASSimple.ENVIRONMENT, fileList, out);

        validateAASX(out);
    }

    private void validateAASX(ByteArrayOutputStream byteStream) throws IOException {
        ZipInputStream in = new ZipInputStream(new ByteArrayInputStream(byteStream.toByteArray()));
        ZipEntry zipEntry = null;

        ArrayList<String> filePaths = new ArrayList<>();

        while ((zipEntry = in.getNextEntry()) != null) {
            if (zipEntry.getName().equals(XML_PATH)) {

                // Read the first 5 bytes of the XML file to make sure it is in fact XML file
                // No further test of XML file necessary as XML-Converter is tested separately
                byte[] buf = new byte[5];
                in.read(buf);
                assertEquals("<?xml", new String(buf));

            }

            // Write the paths of all files contained in the .aasx into filePaths
            filePaths.add(zipEntry.getName());
        }

        assertTrue(filePaths.contains(XML_PATH));
        assertTrue(filePaths.contains(ORIGIN_PATH));

        // Check if all expected files are present
        // Needs to strip the first slash of the paths, as ZipEntry gives paths without
        // it
        for (InMemoryFile file : fileList) {
            assertTrue(filePaths.contains(file.getPath()));
        }

    }
}
