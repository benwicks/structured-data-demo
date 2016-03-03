package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.model.protobuf.wire.SpeciesList;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class WireParser implements DataParser {

    @Override public byte[] encode(List<Species> speciesList) {
        List<SpeciesList.Species> wireSpeciesList = new ArrayList<>(speciesList.size());
        for (Species s : speciesList) {
            wireSpeciesList.add(s.toWireSpecies());
        }
        SpeciesList wireSpeciesListWrapper = new SpeciesList.Builder().speciesList(wireSpeciesList).build();
        return SpeciesList.ADAPTER.encode(wireSpeciesListWrapper);
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        try {
            List<SpeciesList.Species> wireSpeciesList = SpeciesList.ADAPTER.decode(inputStream).speciesList;
            List<Species> speciesList = new ArrayList<>(wireSpeciesList.size());
            for (SpeciesList.Species s : wireSpeciesList) {
                speciesList.add(Species.fromWireSpecies(s));
            }
            return speciesList;
        } catch (ParseException e) {
            throw new Error("Invalid date format", e);
        }
    }
}
