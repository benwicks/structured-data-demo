// Generated code from Butter Knife. Do not modify!
package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DataFormatListItemView$$ViewBinder<T extends com.benjaminwicks.structureddatademo.dataFormatsList.DataFormatListItemView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492951, "field 'nameTextView'");
    target.nameTextView = finder.castView(view, 2131492951, "field 'nameTextView'");
    view = finder.findRequiredView(source, 2131492952, "field 'fileSizeTextView'");
    target.fileSizeTextView = finder.castView(view, 2131492952, "field 'fileSizeTextView'");
  }

  @Override public void unbind(T target) {
    target.nameTextView = null;
    target.fileSizeTextView = null;
  }
}
