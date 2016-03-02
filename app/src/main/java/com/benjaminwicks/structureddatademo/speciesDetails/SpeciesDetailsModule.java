package com.benjaminwicks.structureddatademo.speciesDetails;

import com.benjaminwicks.structureddatademo.MainActivityModule;
import com.benjaminwicks.structureddatademo.model.Species;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                SpeciesDetailsView.class,
        },
        addsTo = MainActivityModule.class
)
final class SpeciesDetailsModule {

    private final Species species;

    SpeciesDetailsModule(Species species) {
        this.species = species;
    }

    @Provides @Singleton Species provideSpecies() {
        return species;
    }
}
