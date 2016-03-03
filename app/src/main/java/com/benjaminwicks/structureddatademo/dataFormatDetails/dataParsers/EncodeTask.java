package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import android.os.AsyncTask;

import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormatDetailsView;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;
import com.benjaminwicks.structureddatademo.model.Species;

import java.lang.ref.WeakReference;
import java.util.List;

public final class EncodeTask extends AsyncTask<Void, Void, Byte[]> {

    private final WeakReference<DataFormatDetailsView> detailsViewReference;
    private final DataParsingMethod dataParsingMethod;
    private final List<Species> speciesList;

    private Exception exception;
    private long startTime;

    public EncodeTask(
            DataFormatDetailsView dataFormatDetailsView,
            DataParsingMethod dataParsingMethod,
            List<Species> speciesList
    ) {
        detailsViewReference = new WeakReference<>(dataFormatDetailsView);
        this.dataParsingMethod = dataParsingMethod;
        this.speciesList = speciesList;
        this.exception = null;
    }

    @Override protected void onPreExecute() {
        super.onPreExecute();
        detailsViewReference.get().onEncodePreExecute();
        startTime = System.nanoTime();
    }

    @Override protected Byte[] doInBackground(Void... params) {
        try {
            byte[] bytes = dataParsingMethod.encode(speciesList);
            Byte[] bytesWrapper = new Byte[bytes.length];
            int i = 0;
            for (byte b : bytes) {
                bytesWrapper[i++] = b;
            }
            return bytesWrapper;
        } catch (Exception e) {
            exception = e;
        }
        return new Byte[]{};
    }

    @Override protected void onPostExecute(Byte[] bytes) {
        super.onPostExecute(bytes);
        detailsViewReference.get().onEncodePostExecute(startTime, exception, bytes);
    }
}
