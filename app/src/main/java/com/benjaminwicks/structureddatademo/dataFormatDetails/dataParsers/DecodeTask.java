package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import android.content.res.AssetManager;
import android.os.AsyncTask;

import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormatDetailsView;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;
import com.benjaminwicks.structureddatademo.model.Species;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public final class DecodeTask extends AsyncTask<Void, Void, List<Species>> {

    private final WeakReference<DataFormatDetailsView> detailsViewReference;
    private final DataParsingMethod dataParsingMethod;
    private final AssetManager assets;

    private Exception exception;
    private long startTime;

    public DecodeTask(DataFormatDetailsView dataFormatDetailsView, DataParsingMethod dataParsingMethod, AssetManager assets) {
        this.dataParsingMethod = dataParsingMethod;
        this.assets = assets;
        this.exception = null;
        this.detailsViewReference = new WeakReference<>(dataFormatDetailsView);
    }

    @Override protected void onPreExecute() {
        super.onPreExecute();
        detailsViewReference.get().onDecodePreExecute();
        startTime = System.nanoTime();
    }

    @Override protected List<Species> doInBackground(Void... params) {
        try {
            return dataParsingMethod.decode(assets);
        } catch (Exception e) {
            this.exception = e;
        }
        return Collections.emptyList();
    }

    @Override protected void onPostExecute(List<Species> species) {
        super.onPostExecute(species);
        detailsViewReference.get().onDecodePostExecute(startTime, species, exception);
    }
}
