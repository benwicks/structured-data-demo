package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.benjaminwicks.structureddatademo.BaseScreen;
import com.benjaminwicks.structureddatademo.DefaultScreenTransition;
import com.jaynewstrom.screenswitcher.ScreenTransition;

public final class DataFormatDetailsScreen extends BaseScreen {

    private final DataParsingMethod child;

    public DataFormatDetailsScreen(DataParsingMethod child) {
        this.child = child;
    }

    @Override public View createViewWithConcreteContext(@NonNull Context context) {
        return new DataFormatDetailsView(context);
    }

    @Override public String name() {
        return getClass().getName();
    }

    @Override public Object daggerModule() {
        return new DataFormatDetailsModule(child);
    }

    @Override public ScreenTransition transition() {
        return DefaultScreenTransition.INSTANCE;
    }
}
