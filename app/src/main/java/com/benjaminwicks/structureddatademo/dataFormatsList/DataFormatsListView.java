package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.view.View;
import android.widget.ExpandableListView;

import com.benjaminwicks.structureddatademo.ScreenManager;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormatDetailsScreen;

import javax.inject.Inject;

final class DataFormatsListView extends ExpandableListView {

    @Inject ScreenManager screenManager;

    private final DataFormatsAdapter dataFormatsAdapter = new DataFormatsAdapter();

    DataFormatsListView(Context context) {
        super(context);
        com.jaynewstrom.concrete.Concrete.inject(context, this);
        setBackgroundResource(android.R.color.white);
        setAdapter(dataFormatsAdapter);
        setOnChildClickListener(new OnChildClickListener() {
            @Override public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                screenManager.push(new DataFormatDetailsScreen(dataFormatsAdapter.getChild(groupPosition, childPosition)));
                return true;
            }
        });
    }
}
