package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.benjaminwicks.structureddatademo.ScreenManager;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormat;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormatDetailsScreen;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;

import javax.inject.Inject;

final class DataFormatsAdapter extends BaseExpandableListAdapter {

    private final ScreenManager screenManager;

    @Inject DataFormatsAdapter(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @Override public int getGroupCount() {
        return DataFormat.values().length;
    }

    @Override public int getChildrenCount(int groupPosition) {
        return getGroup(groupPosition).getChildren().size();
    }

    @Override public DataFormat getGroup(int groupPosition) {
        return DataFormat.values()[groupPosition];
    }

    @Override public DataParsingMethod getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).getChildren().get(childPosition);
    }

    @Override public long getGroupId(int groupPosition) {
        return DataFormat.values()[groupPosition].hashCode();
    }

    @Override public long getChildId(int groupPosition, int childPosition) {
        return DataFormat.values()[groupPosition].getChildren().get(childPosition).hashCode();
    }

    @Override public boolean hasStableIds() {
        return true;
    }

    @Override public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        DataFormatListItemView listItemView = new DataFormatListItemView(parent.getContext());
        listItemView.bind(getGroup(groupPosition));
        return listItemView;
    }

    @Override public View getChildView(
            final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final DataParsingMethodListItemView listItemView;
        if (convertView == null) {
            listItemView = new DataParsingMethodListItemView(parent.getContext());
        } else {
            listItemView = (DataParsingMethodListItemView) convertView;
        }
        listItemView.bind(getChild(groupPosition, childPosition));
        listItemView.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                screenManager.push(new DataFormatDetailsScreen(listItemView, getChild(groupPosition, childPosition)));
            }
        });
        return listItemView;
    }

    @Override public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
