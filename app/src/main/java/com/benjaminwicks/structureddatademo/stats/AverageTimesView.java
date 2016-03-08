package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;

import java.util.Map.Entry;
import java.util.TreeMap;

final class AverageTimesView extends LinearLayout {

    AverageTimesView(Context context) {
        super(context);
        setOrientation(VERTICAL);
        MarginLayoutParams params = new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        int margin = context.getResources().getDimensionPixelSize(R.dimen.graph_margin);
        params.setMargins(margin, margin, margin, margin);
        setLayoutParams(params);
        setBackgroundResource(R.color.gray);
        TreeMap<Long, DataParsingMethod> sortedDecodeTimes = new TreeMap<>();
        TreeMap<Long, DataParsingMethod> sortedEncodeTimes = new TreeMap<>();
        long averageDecodeTime;
        long averageEncodeTime;
        for (DataParsingMethod method : DataParsingMethod.values()) {
            if (method.hasStats(context)) {
                averageDecodeTime = method.getAverageDecodeTime(context);
                averageEncodeTime = method.getAverageEncodeTime(context);
                if (averageDecodeTime > DataParsingMethod.NO_TIME_RECORDED) {
                    sortedDecodeTimes.put(averageDecodeTime, method);
                }
                if (averageEncodeTime > DataParsingMethod.NO_TIME_RECORDED) {
                    sortedEncodeTimes.put(averageEncodeTime, method);
                }
            }
        }
        TextView decodeTimesTextView = new TextView(context);
        decodeTimesTextView.setText(R.string.average_decode_times);
        decodeTimesTextView.setTextSize(25);
        addView(decodeTimesTextView);
        for (Entry e : sortedDecodeTimes.entrySet()) {
            addView(new AverageTimeView(context, e));
        }
        TextView encodeTimesTextView = new TextView(context);
        encodeTimesTextView.setText(R.string.average_encode_times);
        encodeTimesTextView.setTextSize(25);
        addView(encodeTimesTextView);
        for (Entry e : sortedEncodeTimes.entrySet()) {
            addView(new AverageTimeView(context, e));
        }
    }
}
