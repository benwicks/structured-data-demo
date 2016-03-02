package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface DataParser {

    File encode(List<Species> speciesList);

    List<Species> decode(InputStream inputStream);
}
