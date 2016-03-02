package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.model.Species;

import butterknife.Bind;
import butterknife.ButterKnife;

final class SpeciesListItemView extends LinearLayout {

    @Bind(R.id.tv_species_name) TextView speciesNameTextView;

    SpeciesListItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.species_list_item, this);
        ButterKnife.bind(this);
    }

    void bind(Species species) {
        speciesNameTextView.setText(species.species);
    }
}
