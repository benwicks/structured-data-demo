// Generated code from Butter Knife. Do not modify!
package com.benjaminwicks.structureddatademo.dataFormatsList;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DataParsingMethodListItemView$$ViewBinder<T extends com.benjaminwicks.structureddatademo.dataFormatsList.DataParsingMethodListItemView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492951, "field 'nameTextView'");
    target.nameTextView = finder.castView(view, 2131492951, "field 'nameTextView'");
  }

  @Override public void unbind(T target) {
    target.nameTextView = null;
  }
}
