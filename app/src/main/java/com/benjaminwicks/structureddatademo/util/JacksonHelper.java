package com.benjaminwicks.structureddatademo.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
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

    public static <T> T readValue(JsonNode jsonNode, TypeBase type) throws IOException {
        ObjectReader reader = OBJECT_MAPPER.readerFor(type);
        return reader.readValue(jsonNode);
    }

    public static <T> List<T> readListValue(JsonNode jsonNode, Class<T> clazz) throws IOException {
        return readValue(jsonNode, constructListType(clazz));
    }

    public static CollectionType constructListType(Class<?> elementType) {
        return OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, elementType);
    }
}
