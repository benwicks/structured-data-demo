package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.model.protobuf.google.SpeciesListOuterClass;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class ProtobufParser implements DataParser {

    @Override public byte[] encode(List<Species> speciesList) throws IOException {
        List<SpeciesListOuterClass.SpeciesList.Species> googleSpeciesList = new ArrayList<>(speciesList.size());
        for (Species s : speciesList) {
            googleSpeciesList.add(s.toGoogleSpecies());
        }
        return SpeciesListOuterClass.SpeciesList.newBuilder().addAllSpeciesList(googleSpeciesList).build().toByteArray();
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        try {
            List<SpeciesListOuterClass.SpeciesList.Species> googleSpeciesList =
                    SpeciesListOuterClass.SpeciesList.parseFrom(inputStream).getSpeciesListList();
            List<Species> speciesList = new ArrayList<>(googleSpeciesList.size());
            for (SpeciesListOuterClass.SpeciesList.Species s : googleSpeciesList) {
                speciesList.add(Species.fromGoogleSpecies(s));
            }
            return speciesList;
        } catch (ParseException e) {
            throw new Error("Invalid date format", e);
        }
    }
}
