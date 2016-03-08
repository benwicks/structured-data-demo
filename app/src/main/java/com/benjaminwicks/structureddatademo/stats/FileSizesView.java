package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormat;

import java.util.Map.Entry;
import java.util.TreeMap;

final class FileSizesView extends LinearLayout {

    FileSizesView(Context context) {
        super(context);
        setOrientation(VERTICAL);
        MarginLayoutParams params = new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        int margin = context.getResources().getDimensionPixelSize(R.dimen.graph_margin);
        params.setMargins(margin, margin, margin, margin);
        setLayoutParams(params);
        setBackgroundResource(R.color.gray);
        TreeMap<Integer, DataFormat> sortedFileSizes = new TreeMap<>();
        TreeMap<Integer, DataFormat> sortedCompressedFileSizes = new TreeMap<>();
        for (DataFormat format : DataFormat.values()) {
            sortedFileSizes.put(format.fileSizeBytes, format);
            sortedCompressedFileSizes.put(format.gZippedFileSizeBytes, format);
        }
        TextView fileSizesTextView = new TextView(context);
        fileSizesTextView.setText(R.string.uncompressed);
        fileSizesTextView.setTextSize(25);
        addView(fileSizesTextView);
        for (Entry e : sortedFileSizes.entrySet()) {
            addView(new FileSizeView(context, e));
        }
        TextView compressedSizesTextView = new TextView(context);
        compressedSizesTextView.setText(R.string.compressed);
        compressedSizesTextView.setTextSize(25);
        addView(compressedSizesTextView);
        for (Entry e : sortedCompressedFileSizes.entrySet()) {
            addView(new FileSizeView(context, e));
        }
    }
}
