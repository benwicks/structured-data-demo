package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.widget.ScrollView;

import com.benjaminwicks.structureddatademo.R;

final class AverageTimesGraphView extends ScrollView {

    AverageTimesGraphView(Context context) {
        super(context);
        setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
    }
}
