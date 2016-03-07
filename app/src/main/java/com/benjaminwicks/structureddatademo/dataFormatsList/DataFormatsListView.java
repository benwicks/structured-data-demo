package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.ScreenManager;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;
import com.benjaminwicks.structureddatademo.stats.StatisticsScreen;
import com.jaynewstrom.concrete.Concrete;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

final class DataFormatsListView extends LinearLayout {

    @Inject ScreenManager screenManager;
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
//        toolbar.inflateMenu(R.menu.data_formats_screen); // un-comment if I get to the StatisticsView
        toolbar.setOnMenuItemClickListener(oneMenuItemClickListener);
        listView.setAdapter(dataFormatsAdapter);
    }

    private final OnMenuItemClickListener oneMenuItemClickListener = new OnMenuItemClickListener() {
        @Override public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_stats:
                    if (DataParsingMethod.hasAnyStats(getContext())) {
                        screenManager.push(new StatisticsScreen(listView));
                    } else {
                        Toast.makeText(getContext(), R.string.no_stats_yet, Toast.LENGTH_SHORT).show();
                    }
                    return true;
            }
            return false;
        }
    };
}
