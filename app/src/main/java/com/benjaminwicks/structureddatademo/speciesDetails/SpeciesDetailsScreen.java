package com.benjaminwicks.structureddatademo.speciesDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.benjaminwicks.structureddatademo.BaseScreen;
import com.benjaminwicks.structureddatademo.DefaultScreenTransition;
import com.benjaminwicks.structureddatademo.model.Species;
import com.jaynewstrom.screenswitcher.ScreenTransition;

public final class SpeciesDetailsScreen extends BaseScreen {

    private final Species species;

    public SpeciesDetailsScreen(Species species) {
        this.species = species;
    }

    @Override protected View createViewWithConcreteContext(@NonNull Context context) {
        return new SpeciesDetailsView(context);
    }

    @Override public String name() {
        return getClass().getName();
    }

    @Override public Object daggerModule() {
        return new SpeciesDetailsModule(species);
    }

    @Override public ScreenTransition transition() {
        return DefaultScreenTransition.INSTANCE;
    }
}
