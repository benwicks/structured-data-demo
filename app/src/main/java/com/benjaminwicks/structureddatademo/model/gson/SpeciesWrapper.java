package com.benjaminwicks.structureddatademo.model.gson;

import com.benjaminwicks.structureddatademo.model.Species;

import java.util.List;

public final class SpeciesWrapper {

    private final List<Species> species;

    public SpeciesWrapper(
            List<Species> species
    ) {
        this.species = species;
    }

    public List<Species> getSpeciesList() {
        return species;
    }
}
