package com.benjaminwicks.structureddatademo.stats;

import android.widget.ExpandableListView;
import android.widget.Toast;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.ScreenManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class StatisticsStateHolder {

    private final ScreenManager screenManager;
    private final ExpandableListView parsingMethodsListView;

    private StatisticsView viewReference;

    @Inject StatisticsStateHolder(ScreenManager screenManager, ExpandableListView parsingMethodsListView) {
        this.screenManager = screenManager;
        this.parsingMethodsListView = parsingMethodsListView;
    }

    void setViewReference(StatisticsView viewReference) {
        this.viewReference = viewReference;
    }

    void dropViewReference() {
        this.viewReference = null;
    }

    void onPreDelete() {
        if (viewReference != null) {
            viewReference.onPreDelete();
        }
    }

    void onPostDelete(Integer numMethodStatsDeleted) {
        if (viewReference != null) {
            viewReference.onPostDelete();
            Toast.makeText(
                    viewReference.getContext(),
                    viewReference.getContext().getResources()
                                 .getQuantityString(R.plurals.num_deleted_format, numMethodStatsDeleted, numMethodStatsDeleted),
                    Toast.LENGTH_SHORT
            ).show();
            if (parsingMethodsListView != null) {
                parsingMethodsListView.invalidateViews();
            }
            screenManager.pop();
        }
    }
}
