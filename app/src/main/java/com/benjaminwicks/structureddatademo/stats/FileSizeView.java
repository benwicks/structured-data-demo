package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.BytesFormatHelper;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormat;

import java.util.Map.Entry;

import butterknife.Bind;
import butterknife.ButterKnife;

final class FileSizeView extends LinearLayout {

    @Bind(R.id.tv_name) TextView nameTextView;
    @Bind(R.id.tv_size) TextView sizeTextView;

    FileSizeView(Context context, Entry e) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.data_format_file_size, this);
        ButterKnife.bind(this);
        nameTextView.setText(((DataFormat) e.getValue()).name);
        sizeTextView.setText(BytesFormatHelper.formatBytes((Integer) e.getKey()));
    }
}
