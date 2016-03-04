package com.benjaminwicks.structureddatademo.stats;

import android.widget.ExpandableListView;

import com.benjaminwicks.structureddatademo.MainActivityModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                StatisticsView.class,
        },
        addsTo = MainActivityModule.class
)
final class StatisticsModule {

    private final ExpandableListView parsingMethodsListView;

    StatisticsModule(ExpandableListView parsingMethodsListView) {
        this.parsingMethodsListView = parsingMethodsListView;
    }

    @Provides @Singleton ExpandableListView provideParsingMethodsListView() {
        return parsingMethodsListView;
    }
}
