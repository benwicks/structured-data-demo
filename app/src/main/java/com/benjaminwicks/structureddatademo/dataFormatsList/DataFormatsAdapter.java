package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormat;
import com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod;

final class DataFormatsAdapter extends BaseExpandableListAdapter {

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

    @Override public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        DataParsingMethodListItemView listItemView = new DataParsingMethodListItemView(parent.getContext());
        listItemView.bind(getChild(groupPosition, childPosition));
        return listItemView;
    }

    @Override public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
