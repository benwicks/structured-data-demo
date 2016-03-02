package com.benjaminwicks.structureddatademo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class SpeciesListWrapper {

    public final List<Species> speciesList;

    @JsonCreator SpeciesListWrapper(
            @JsonProperty("species") List<Species> speciesList
    ) {
        this.speciesList = speciesList;
    }
}
