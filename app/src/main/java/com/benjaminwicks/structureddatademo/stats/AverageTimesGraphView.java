package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

import com.benjaminwicks.structureddatademo.R;

final class AverageTimesGraphView extends View {

    AverageTimesGraphView(Context context) {
        super(context);
        MarginLayoutParams params = new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        int margin = context.getResources().getDimensionPixelSize(R.dimen.graph_margin);
        params.setMargins(margin, margin, margin, margin);
        setLayoutParams(params);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.graph_min_height));
        setBackgroundResource(R.color.gray);
    }
}
