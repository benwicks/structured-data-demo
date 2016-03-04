package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.os.AsyncTask;

import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;

final class DeleteAllStatsTask extends AsyncTask<Void, Void, Integer> {

    private final StatisticsStateHolder stateHolder;
    private final Context context;

    DeleteAllStatsTask(StatisticsStateHolder stateHolder, Context applicationContext) {
        this.stateHolder = stateHolder;
        this.context = applicationContext;
    }

    @Override protected void onPreExecute() {
        super.onPreExecute();
        stateHolder.onPreDelete();
    }

    @Override protected Integer doInBackground(Void... params) {
        int numMethodStatsDeleted = 0;
        for (DataParsingMethod method : DataParsingMethod.values()) {
            if (method.deleteStats(context)) {
                numMethodStatsDeleted++;
            }
        }
        return numMethodStatsDeleted;
    }

    @Override protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        stateHolder.onPostDelete(integer);
    }
}
