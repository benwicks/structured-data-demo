package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;

import butterknife.Bind;
import butterknife.ButterKnife;

final class DataParsingMethodListItemView extends LinearLayout {

    @Bind(R.id.tv_name) TextView nameTextView;

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
        nameTextView.setText(parsingMethod.name);
    }
}
