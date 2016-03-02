package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;
import com.benjaminwicks.structureddatademo.dataFormatDetails.TimeFormatHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

final class DataParsingMethodListItemView extends LinearLayout {

    @Bind(R.id.tv_name) TextView nameTextView;
    @Bind(R.id.ll_stats) ViewGroup statsLayout;
    @Bind(R.id.tv_average_decode_time) TextView averageDecodeTimeTextView;
    @Bind(R.id.tv_average_encode_time) TextView averageEncodeTimeTextView;
    @Bind(R.id.tv_run_count) TextView runCountTextView;

    DataParsingMethodListItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.parsing_method_list_item, this);
        ButterKnife.bind(this);
    }

    void bind(DataParsingMethod parsingMethod) {
        nameTextView.setText(parsingMethod.name);
        int runCount = parsingMethod.getRunCount();
        if (runCount > 0) {
            statsLayout.setVisibility(View.VISIBLE);
            averageDecodeTimeTextView.setText(TimeFormatHelper.formatMilliseconds(parsingMethod.getAverageDecodeTime()));
            averageEncodeTimeTextView.setText(TimeFormatHelper.formatMilliseconds(parsingMethod.getAverageEncodeTime()));
            runCountTextView.setText(String.valueOf(runCount));
        } else {
            statsLayout.setVisibility(View.GONE);
        }
    }
}
