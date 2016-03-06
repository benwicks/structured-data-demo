package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.model.gson.SpeciesWrapper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public final class GsonParser implements DataParser {

    @Override public byte[] encode(List<Species> speciesList) throws IOException {
        return new GsonBuilder()
                .setDateFormat(Species.DATE_FORMAT.toPattern())
                .create()
                .toJson(new SpeciesWrapper(speciesList)).getBytes();
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        JsonElement jsonElement = new JsonParser().parse(reader).getAsJsonObject();
        reader.close();
        return new GsonBuilder()
                .setDateFormat(Species.DATE_FORMAT.toPattern())
                .create()
                .fromJson(jsonElement, SpeciesWrapper.class)
                .getSpeciesList();
    }
}
