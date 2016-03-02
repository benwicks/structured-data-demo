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
    view = finder.findRequiredView(source, 2131492966, "field 'statsLayout'");
    target.statsLayout = finder.castView(view, 2131492966, "field 'statsLayout'");
    view = finder.findRequiredView(source, 2131492967, "field 'averageDecodeTimeTextView'");
    target.averageDecodeTimeTextView = finder.castView(view, 2131492967, "field 'averageDecodeTimeTextView'");
    view = finder.findRequiredView(source, 2131492968, "field 'averageEncodeTimeTextView'");
    target.averageEncodeTimeTextView = finder.castView(view, 2131492968, "field 'averageEncodeTimeTextView'");
    view = finder.findRequiredView(source, 2131492969, "field 'runCountTextView'");
    target.runCountTextView = finder.castView(view, 2131492969, "field 'runCountTextView'");
  }

  @Override public void unbind(T target) {
    target.nameTextView = null;
    target.statsLayout = null;
    target.averageDecodeTimeTextView = null;
    target.averageEncodeTimeTextView = null;
    target.runCountTextView = null;
  }
}
