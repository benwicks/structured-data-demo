package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.benjaminwicks.structureddatademo.BaseScreen;
import com.benjaminwicks.structureddatademo.DefaultScreenTransition;
import com.jaynewstrom.screenswitcher.ScreenTransition;

public final class DataFormatsListScreen extends BaseScreen {

    @Override public View createViewWithConcreteContext(@NonNull Context context) {
        return new DataFormatsListView(context);
    }

    @Override public String name() {
        return getClass().getName();
    }

    @Override public Object daggerModule() {
        return new DataFormatsListScreenModule();
    }

    @Override public ScreenTransition transition() {
        return DefaultScreenTransition.INSTANCE;
    }
}
