package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;
import com.benjaminwicks.structureddatademo.dataFormatDetails.TimeFormatHelper;

import java.util.Map.Entry;

import butterknife.Bind;
import butterknife.ButterKnife;

final class AverageTimeView extends LinearLayout {

    @Bind(R.id.tv_name) TextView nameTextView;
    @Bind(R.id.tv_time) TextView timeTextView;

    AverageTimeView(Context context, Entry e) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.average_time, this);
        ButterKnife.bind(this);
        nameTextView.setText(((DataParsingMethod) e.getValue()).name);
        timeTextView.setText(TimeFormatHelper.formatMilliseconds((Long) e.getKey()));
    }
}
