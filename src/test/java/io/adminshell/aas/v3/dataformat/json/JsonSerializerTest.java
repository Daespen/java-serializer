package io.adminshell.aas.v3.dataformat.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.json.JSONException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.adminshell.aas.v3.dataformat.SerializationException;
import io.adminshell.aas.v3.model.AssetAdministrationShellEnvironment;
import io.adminshell.aas.v3.model.impl.DefaultAssetAdministrationShellEnvironment;
import java.nio.file.Files;

public class JsonSerializerTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonSerializerTest.class);

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testSerializeNull() throws JsonProcessingException, IOException, SerializationException {
        assertEquals("null", new JsonSerializer().write(null));
    }

    @Test
    public void testWriteToFile() throws JsonProcessingException, IOException, SerializationException {
        File file = tempFolder.newFile("output.json");
        new JsonSerializer().write(file, AASSimple.ENVIRONMENT);
        assertTrue(file.exists());
    }

    @Test
    public void testSerializeEmpty() throws JsonProcessingException, IOException, SerializationException, JSONException {
        validateAndCompare(new java.io.File("src/test/resources/empty_aas.json"), new DefaultAssetAdministrationShellEnvironment.Builder().build());
    }

    @Test
    public void testSerializeSimpleExample() throws SerializationException, JSONException, IOException {
        validateAndCompare(AASSimple.FILE, AASSimple.ENVIRONMENT);
    }

    @Test
    public void testSerializeFullExample() throws SerializationException, JSONException, IOException {
        validateAndCompare(AASFull.FILE, AASFull.ENVIRONMENT);
    }

    private void validateAndCompare(File expectedFile, AssetAdministrationShellEnvironment environment) throws IOException, SerializationException, JSONException {
        String expected = Files.readString(expectedFile.toPath());
        String actual = new JsonSerializer().write(environment);
        logger.info(actual);
        Set<String> errors = new JsonSchemaValidator().validateSchema(actual);
        assertTrue(errors.isEmpty());
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.NON_EXTENSIBLE);
        JSONAssert.assertEquals(actual, expected, JSONCompareMode.NON_EXTENSIBLE);
    }

}
