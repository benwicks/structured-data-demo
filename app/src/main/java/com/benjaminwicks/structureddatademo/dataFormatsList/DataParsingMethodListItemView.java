package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;
import com.benjaminwicks.structureddatademo.dataFormatDetails.TimeFormatHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public final class DataParsingMethodListItemView extends LinearLayout {

    @Bind(R.id.tv_name) TextView nameTextView;
    @Bind(R.id.ll_stats) View statsLayout;
    @Bind(R.id.tv_average_decode_time) TextView averageDecodeTimeTextView;
    @Bind(R.id.tv_average_encode_time) TextView averageEncodeTimeTextView;

    private DataParsingMethod parsingMethod;

    DataParsingMethodListItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.parsing_method_list_item, this);
        setOrientation(VERTICAL);
        ButterKnife.bind(this);
        Resources resources = context.getResources();
        int horizontalPadding = resources.getDimensionPixelSize(R.dimen.list_horizontal_padding);
        int verticalPadding = resources.getDimensionPixelSize(R.dimen.list_vertical_padding);
        setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
    }

    void bind(DataParsingMethod parsingMethod) {
        this.parsingMethod = parsingMethod;
        nameTextView.setText(parsingMethod.name);
        runStatsLoaderTask();
    }

    public void runStatsLoaderTask() {
        new DataParsingMethodStatsLoaderTask(this, parsingMethod).execute();
    }

    static void setupTextView(TextView averageTimeTextView, long averageTime) {
        if (averageTime == DataParsingMethod.NO_TIME_RECORDED) {
            averageTimeTextView.setText(R.string.no_data_yet);
        } else {
            averageTimeTextView.setText(TimeFormatHelper.formatMilliseconds(averageTime));
        }
    }
}
