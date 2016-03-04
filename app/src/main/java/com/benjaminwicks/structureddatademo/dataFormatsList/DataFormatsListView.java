package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.benjaminwicks.structureddatademo.R;
import com.jaynewstrom.concrete.Concrete;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

final class DataFormatsListView extends LinearLayout {

    @Inject DataFormatsAdapter dataFormatsAdapter;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.list_view) ExpandableListView listView;

    DataFormatsListView(Context context) {
        super(context);
        Concrete.inject(context, this);
        setBackgroundResource(android.R.color.white);
        LayoutInflater.from(context).inflate(R.layout.data_formats_list, this);
        ButterKnife.bind(this);
        setupView();
    }

    private void setupView() {
        toolbar.setTitle(R.string.app_name);
        listView.setAdapter(dataFormatsAdapter);
    }
}
