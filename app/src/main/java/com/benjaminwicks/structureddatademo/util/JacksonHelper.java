package com.benjaminwicks.structureddatademo.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeBase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public final class JacksonHelper {

    public static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US));
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    private JacksonHelper() {
        // no instances
    }

    public static boolean getBoolean(JsonNode json, String key, boolean defaultValue) {
        boolean value = defaultValue;

        if (json.has(key)) {
            JsonNode valueJson = json.get(key);
            if (valueJson != null) {
                value = valueJson.asBoolean();
            }
        }

        return value;
    }

    public static String getString(JsonNode json, String key, String defaultValue) {
        String value = defaultValue;

        if (json != null && json.has(key)) {
            JsonNode valueJson = json.get(key);
            if (valueJson != null) {
                value = valueJson.asText();

                if (value.equals("null")) {
                    value = defaultValue;
                }
            }
        }

        return value;
    }

    public static long getLong(JsonNode json, String key, long defaultValue) {
        long value = defaultValue;

        if (json != null && json.has(key)) {
            JsonNode valueJson = json.get(key);
            if (valueJson != null) {
                value = valueJson.asLong();
            }
        }

        return value;
    }

    public static double getDouble(JsonNode json, String key, double defaultValue) {
        double value = defaultValue;

        if (json.has(key)) {
            JsonNode valueJson = json.get(key);
            if (valueJson != null) {
                value = valueJson.asDouble();
            }
        }

        return value;
    }

    public static int getInt(JsonNode json, String key, int defaultValue) {
        int value = defaultValue;

        if (json.has(key)) {
            JsonNode valueJson = json.get(key);
            if (valueJson != null) {
                value = valueJson.asInt();
            }
        }

        return value;
    }

    public static ObjectNode createObjectNode() {
        return OBJECT_MAPPER.createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        return OBJECT_MAPPER.createArrayNode();
    }

    public static JsonNode readTree(String stringJson) throws IOException {
        return OBJECT_MAPPER.readTree(stringJson);
    }

    public static <T> T readValue(JsonNode jsonNode, Class<T> clazz) throws IOException {
        ObjectReader reader = OBJECT_MAPPER.readerFor(clazz);
        return reader.readValue(jsonNode);
    }

    public static <T> T readValue(JsonNode jsonNode, TypeBase type) throws IOException {
        ObjectReader reader = OBJECT_MAPPER.readerFor(type);
        return reader.readValue(jsonNode);
    }

    public static <T> T readValue(JsonNode jsonNode, JavaType javaType) throws IOException {
        ObjectReader reader = OBJECT_MAPPER.readerFor(javaType);
        return reader.readValue(jsonNode);
    }

    public static <T> List<T> readListValue(JsonNode jsonNode, Class<T> clazz) throws IOException {
        return readValue(jsonNode, constructListType(clazz));
    }

    public static CollectionType constructListType(Class<?> elementType) {
        return OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, elementType);
    }
}
