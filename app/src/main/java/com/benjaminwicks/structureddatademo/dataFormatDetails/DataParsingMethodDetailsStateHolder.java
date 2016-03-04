package com.benjaminwicks.structureddatademo.dataFormatDetails;

import com.benjaminwicks.structureddatademo.model.Species;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class DataParsingMethodDetailsStateHolder {

    private final SpeciesAdapter speciesAdapter = new SpeciesAdapter();

    private boolean isCurrentlyTranscoding;
    private String lastDecodeTimeText;
    private String lastEncodeTimeText;
    private String lastEmptyText;
    private DataFormatDetailsView viewReference;

    @Inject DataParsingMethodDetailsStateHolder() {
    }

    boolean isEncodeEnabled() {
        return !isCurrentlyTranscoding && !speciesAdapter.isEmpty();
    }

    void setIsCurrentlyTranscoding(boolean isCurrentlyTranscoding) {
        this.isCurrentlyTranscoding = isCurrentlyTranscoding;
        if (viewReference != null) {
            viewReference.decodeButton.setEnabled(!isCurrentlyTranscoding);
            viewReference.encodeButton.setEnabled(isEncodeEnabled());
        }
    }

    String getLastDecodeTimeText() {
        return lastDecodeTimeText;
    }

    void setLastDecodeTimeText(String lastDecodeTimeText) {
        this.lastDecodeTimeText = lastDecodeTimeText;
        if (viewReference != null) {
            viewReference.decodeTimeTextView.setText(lastDecodeTimeText);
        }
    }

    String getLastEncodeTimeText() {
        return lastEncodeTimeText;
    }

    void setLastEncodeTimeText(String lastEncodeTimeText) {
        this.lastEncodeTimeText = lastEncodeTimeText;
    }

    String getLastEmptyText() {
        return lastEmptyText;
    }

    void setLastEmptyText(String lastEmptyText) {
        this.lastEmptyText = lastEmptyText;
        if (viewReference != null) {
            viewReference.emptyTextView.setText(lastEmptyText);
        }
    }

    SpeciesAdapter getSpeciesAdapter() {
        return speciesAdapter;
    }

    List<Species> getSpeciesList() {
        return speciesAdapter.getSpeciesList();
    }

    void setSpeciesList(List<Species> species) {
        speciesAdapter.setSpeciesList(species);
        if (viewReference != null) {
            viewReference.listView.invalidate();
        }
    }

    Species getSpeciesAtPosition(int position) {
        return speciesAdapter.getItem(position);
    }

    void setViewReference(DataFormatDetailsView viewReference) {
        this.viewReference = viewReference;
    }

    void dropViewReference() {
        this.viewReference = null;
    }
}
