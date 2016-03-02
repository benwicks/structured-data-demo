package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.model.protobuf.wire.SpeciesList;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class WireParser implements DataParser {

    @Override public File encode(List<Species> speciesList) {
        return null;
    }

    @Override public List<Species> decode(InputStream inputStream) {
        try {
            List<SpeciesList.Species> wireSpeciesList = SpeciesList.ADAPTER.decode(inputStream).speciesList;
            List<Species> speciesList = new ArrayList<>(wireSpeciesList.size());
            for (SpeciesList.Species s : wireSpeciesList) {
                speciesList.add(Species.fromWireSpecies(s));
            }
            return speciesList;
        } catch (IOException e) {
            throw new AssertionError("Invalid Protobuf", e);
        } catch (ParseException e) {
            throw new AssertionError("Invalid date format", e);
        }
    }
}
