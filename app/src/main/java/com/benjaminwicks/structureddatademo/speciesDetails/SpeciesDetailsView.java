package com.benjaminwicks.structureddatademo.speciesDetails;

import android.content.Context;
import android.widget.LinearLayout;

import com.benjaminwicks.structureddatademo.model.Species;
import com.jaynewstrom.concrete.Concrete;

import javax.inject.Inject;

final class SpeciesDetailsView extends LinearLayout {

    @Inject Species species;

    SpeciesDetailsView(Context context) {
        super(context);
        Concrete.inject(context, this);
        setBackgroundResource(android.R.color.white);
    }
}
