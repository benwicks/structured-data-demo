package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.benjaminwicks.structureddatademo.model.Species;

import java.util.ArrayList;
import java.util.List;

final class SpeciesAdapter extends BaseAdapter {

    private final List<Species> species;

    SpeciesAdapter() {
        species = new ArrayList<>();
    }

    @Override public int getCount() {
        return species.size();
    }

    @Override public Species getItem(int position) {
        return species.get(position);
    }

    @Override public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        SpeciesListItemView listItemView = new SpeciesListItemView(parent.getContext());
        listItemView.bind(getItem(position));
        return listItemView;
    }

    void setSpeciesList(List<Species> speciesList) {
        species.clear();
        species.addAll(speciesList);
        notifyDataSetInvalidated();
    }
}
