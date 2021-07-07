package io.adminshell.aas.v3.dataformat.xml.deserialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.adminshell.aas.v3.model.KeyElements;
import io.adminshell.aas.v3.model.KeyType;
import io.adminshell.aas.v3.model.impl.DefaultKey;

public class KeyDeserializer extends JsonDeserializer<DefaultKey> {

    @Override
    public DefaultKey deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectNode node = DeserializationHelper.getRootObjectNode(parser);
        ObjectNode normalizeNode = normalizeNode(node);
        return createDefaultKeyFromNode(parser, normalizeNode);
    }

    private DefaultKey createDefaultKeyFromNode(JsonParser parser, ObjectNode normalizeNode) throws IOException {
        JsonNode idTypeNode = normalizeNode.get("idType");
        JsonNode typeNode = normalizeNode.get("type");
        JsonNode valueNode = normalizeNode.get("");
        KeyType idType = createKeyTypeFromNode(parser, idTypeNode);
        KeyElements type = createKeyElementsFromNode(parser, typeNode);
        String value = valueNode.asText();
        return new DefaultKey.Builder().idType(idType).type(type).value(value).build();
    }

    private ObjectNode normalizeNode(ObjectNode node) {
        if (node.has("key")) {
            node = (ObjectNode) node.get("key");
        }
        return node;
    }

    private KeyElements createKeyElementsFromNode(JsonParser parser, JsonNode typeNode) throws IOException {
        return DeserializationHelper.createInstanceFromNode(parser, typeNode, KeyElements.class);
    }

    private KeyType createKeyTypeFromNode(JsonParser parser, JsonNode idTypeNode) throws IOException {
        return DeserializationHelper.createInstanceFromNode(parser, idTypeNode, KeyType.class);
    }

}