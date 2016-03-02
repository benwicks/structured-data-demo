package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.util.JacksonHelper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class JacksonParser implements DataParser {

    @Override public File encode(List<Species> speciesList) {
        return null;
    }

    @Override public List<Species> decode(InputStream inputStream) {
        try {
            return JacksonHelper.readListValue(JacksonHelper.OBJECT_MAPPER.readTree(inputStream).get("species"), Species.class);
        } catch (IOException e) {
            throw new AssertionError("Invalid Json", e);
        }
    }
}
