package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.widget.ExpandableListView;

import javax.inject.Inject;

final class DataFormatsListView extends ExpandableListView {

    @Inject DataFormatsAdapter dataFormatsAdapter;

    DataFormatsListView(Context context) {
        super(context);
        com.jaynewstrom.concrete.Concrete.inject(context, this);
        setBackgroundResource(android.R.color.white);
        setAdapter(dataFormatsAdapter);
    }
}
