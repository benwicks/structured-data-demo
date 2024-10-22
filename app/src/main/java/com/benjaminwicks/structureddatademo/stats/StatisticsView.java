package com.benjaminwicks.structureddatademo.stats;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.benjaminwicks.structureddatademo.ForApplication;
import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.ScreenManager;
import com.jaynewstrom.concrete.Concrete;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

final class StatisticsView extends LinearLayout {

    @Inject @ForApplication Context applicationContext;
    @Inject ScreenManager screenManager;
    @Inject StatisticsStateHolder stateHolder;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.progress_bar) View progressBarView;
    @Bind(R.id.ll_stats) LinearLayout statsLayout;

    StatisticsView(Context context) {
        super(context);
        Concrete.inject(context, this);
        LayoutInflater.from(context).inflate(R.layout.statistics, this);
        ButterKnife.bind(this);
        setOrientation(VERTICAL);
        setupView();
    }

    private void setupView() {
        toolbar.setTitle(R.string.statistics);
        toolbar.inflateMenu(R.menu.statistics_screen);
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        progressBarView.setOnTouchListener(new OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        statsLayout.addView(new AverageTimesView(getContext()), 1);
        statsLayout.addView(new FileSizesView(getContext()), 4);
        statsLayout.invalidate();
    }

    private final OnMenuItemClickListener onMenuItemClickListener = new OnMenuItemClickListener() {
        @Override public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_delete:
                    onDeleteClicked();
                    return true;
            }
            return false;
        }
    };

    private void onDeleteClicked() {
        toolbar.dismissPopupMenus();
        new DeleteAllStatsTask(stateHolder, applicationContext).execute();
    }

    void onPreDelete() {
        progressBarView.setVisibility(View.VISIBLE);
    }

    void onPostDelete() {
        progressBarView.setVisibility(View.GONE);
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        stateHolder.setViewReference(this);
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stateHolder.dropViewReference();
    }
}
