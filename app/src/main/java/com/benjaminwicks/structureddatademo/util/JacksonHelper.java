package com.benjaminwicks.structureddatademo.util;

import com.benjaminwicks.structureddatademo.model.Species;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeBase;

import java.io.IOException;
import java.util.List;

public final class JacksonHelper {

    public static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setDateFormat(Species.DATE_FORMAT);
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
