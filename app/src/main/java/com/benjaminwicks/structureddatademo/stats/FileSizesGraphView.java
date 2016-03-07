package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormat;

final class FileSizesGraphView extends View {

    private Paint textPaint;
    private Paint drawingPaint;

    FileSizesGraphView(Context context) {
        super(context);
        init();
    }

    private void init() {
        MarginLayoutParams params = new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        Resources resources = getContext().getResources();
        int margin = resources.getDimensionPixelSize(R.dimen.graph_margin);
        params.setMargins(margin, margin, margin, margin);
        setLayoutParams(params);
        setMinimumHeight(resources.getDimensionPixelSize(R.dimen.graph_min_height));
        int maxSize = 0;
        for (DataFormat format : DataFormat.values()) {
            if (format.fileSizeBytes > maxSize) {
                maxSize = format.fileSizeBytes;
            }
        }
        int maxCompressedSize = 0;
        for (DataFormat format : DataFormat.values()) {
            if (format.gZippedFileSizeBytes > maxCompressedSize) {
                maxCompressedSize = format.gZippedFileSizeBytes;
            }
        }
        setBackgroundResource(R.color.gray);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(12);

        drawingPaint = new Paint();
        drawingPaint.setColor(Color.BLACK);
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // draw custom graph views
    }
}
