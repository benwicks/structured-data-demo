package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ExpandableListView;

import com.benjaminwicks.structureddatademo.BaseScreen;
import com.benjaminwicks.structureddatademo.DefaultScreenTransition;
import com.jaynewstrom.screenswitcher.ScreenTransition;

public final class StatisticsScreen extends BaseScreen {

    private final ExpandableListView parsingMethodsListView;

    public StatisticsScreen(ExpandableListView parsingMethodsListView) {
        this.parsingMethodsListView = parsingMethodsListView;
    }

    @Override protected View createViewWithConcreteContext(@NonNull Context context) {
        return new StatisticsView(context);
    }

    @Override public String name() {
        return getClass().getName();
    }

    @Override public Object daggerModule() {
        return new StatisticsModule(parsingMethodsListView);
    }

    @Override public ScreenTransition transition() {
        return DefaultScreenTransition.INSTANCE;
    }
}
