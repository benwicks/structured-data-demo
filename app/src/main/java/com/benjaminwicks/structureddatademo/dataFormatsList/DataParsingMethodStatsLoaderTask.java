package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;

import java.lang.ref.WeakReference;

final class DataParsingMethodStatsLoaderTask extends AsyncTask<Void, Void, Void> {

    private final WeakReference<DataParsingMethodListItemView> viewReference;
    private final Context context;
    private final DataParsingMethod parsingMethod;

    private boolean hasStats;
    private long averageDecodeTime;
    private long averageEncodeTime;

    DataParsingMethodStatsLoaderTask(DataParsingMethodListItemView view, DataParsingMethod parsingMethod) {
        viewReference = new WeakReference<>(view);
        context = view.getContext();
        this.parsingMethod = parsingMethod;
        hasStats = false;
        averageDecodeTime = 0;
        averageEncodeTime = 0;
    }

    @Override protected Void doInBackground(Void... params) {
        if (parsingMethod.hasStats(context)) {
            hasStats = true;
            averageDecodeTime = parsingMethod.getAverageDecodeTime(context);
            averageEncodeTime = parsingMethod.getAverageEncodeTime(context);
        }
        return null;
    }

    @Override protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (hasStats) {
            viewReference.get().statsLayout.setVisibility(View.VISIBLE);
            DataParsingMethodListItemView.setupTextView(viewReference.get().averageDecodeTimeTextView, averageDecodeTime);
            DataParsingMethodListItemView.setupTextView(viewReference.get().averageEncodeTimeTextView, averageEncodeTime);
        } else {
            viewReference.get().statsLayout.setVisibility(View.GONE);
        }
    }
}
