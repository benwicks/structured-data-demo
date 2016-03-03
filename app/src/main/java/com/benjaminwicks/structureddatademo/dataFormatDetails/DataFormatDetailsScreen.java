package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.benjaminwicks.structureddatademo.BaseScreen;
import com.benjaminwicks.structureddatademo.DefaultScreenTransition;
import com.benjaminwicks.structureddatademo.dataFormatsList.DataParsingMethodListItemView;
import com.jaynewstrom.screenswitcher.ScreenTransition;

public final class DataFormatDetailsScreen extends BaseScreen {

    private final DataParsingMethodListItemView listItemView;
    private final DataParsingMethod child;

    public DataFormatDetailsScreen(DataParsingMethodListItemView listItemView, DataParsingMethod child) {
        this.listItemView = listItemView;
        this.child = child;
    }

    @Override protected View createViewWithConcreteContext(@NonNull Context context) {
        return new DataFormatDetailsView(context, listItemView);
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
