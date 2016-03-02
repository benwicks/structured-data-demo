package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface DataParser {

    byte[] encode(List<Species> speciesList) throws IOException;

    List<Species> decode(InputStream inputStream) throws IOException;
}
