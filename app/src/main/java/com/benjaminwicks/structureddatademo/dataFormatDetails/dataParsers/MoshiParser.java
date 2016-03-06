package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.model.gson.SpeciesWrapper;
import com.benjaminwicks.structureddatademo.model.moshi.SpeciesDateAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okio.Okio;

public final class MoshiParser implements DataParser {

    private static final JsonAdapter<SpeciesWrapper> ADAPTER = new Moshi.Builder()
            .add(new SpeciesDateAdapter())
            .build()
            .adapter(SpeciesWrapper.class);

    @Override public byte[] encode(List<Species> speciesList) throws IOException {
        return ADAPTER.toJson(new SpeciesWrapper(speciesList)).getBytes();
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        return ADAPTER.fromJson(Okio.buffer(Okio.source(inputStream))).getSpeciesList();
    }
}
