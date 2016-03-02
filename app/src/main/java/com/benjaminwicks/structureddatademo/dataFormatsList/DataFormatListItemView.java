package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormat;

import butterknife.Bind;
import butterknife.ButterKnife;

final class DataFormatListItemView extends LinearLayout {

    @Bind(R.id.tv_name) TextView nameTextView;
    @Bind(R.id.tv_file_size) TextView fileSizeTextView;

    DataFormatListItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.data_format_list_item, this);
        ButterKnife.bind(this);
    }

    void bind(DataFormat dataFormat) {
        nameTextView.setText(dataFormat.name);
        fileSizeTextView.setText(getContext().getString(R.string.file_size_format, dataFormat.fileSize));
    }
}
