package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.util.JacksonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class JacksonParser implements DataParser {

    @Override public byte[] encode(List<Species> speciesList) throws JsonProcessingException {
        return JacksonHelper.OBJECT_MAPPER.writer().writeValueAsBytes(speciesList);
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        return JacksonHelper.readListValue(JacksonHelper.OBJECT_MAPPER.readTree(inputStream).get("species"), Species.class);
    }
}
