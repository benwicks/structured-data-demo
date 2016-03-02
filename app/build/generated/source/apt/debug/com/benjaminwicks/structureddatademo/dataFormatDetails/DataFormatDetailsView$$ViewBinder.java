// Generated code from Butter Knife. Do not modify!
package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DataFormatDetailsView$$ViewBinder<T extends com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormatDetailsView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492944, "field 'dataFormatTextView'");
    target.dataFormatTextView = finder.castView(view, 2131492944, "field 'dataFormatTextView'");
    view = finder.findRequiredView(source, 2131492945, "field 'dataParsingMethodTextView'");
    target.dataParsingMethodTextView = finder.castView(view, 2131492945, "field 'dataParsingMethodTextView'");
    view = finder.findRequiredView(source, 2131492946, "field 'decodeTimeTextView'");
    target.decodeTimeTextView = finder.castView(view, 2131492946, "field 'decodeTimeTextView'");
    view = finder.findRequiredView(source, 2131492947, "field 'decodeButton' and method 'onClickDecode'");
    target.decodeButton = finder.castView(view, 2131492947, "field 'decodeButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickDecode();
        }
      });
    view = finder.findRequiredView(source, 2131492948, "field 'encodeTimeTextView'");
    target.encodeTimeTextView = finder.castView(view, 2131492948, "field 'encodeTimeTextView'");
    view = finder.findRequiredView(source, 2131492949, "field 'encodeButton' and method 'onClickEncode'");
    target.encodeButton = finder.castView(view, 2131492949, "field 'encodeButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickEncode();
        }
      });
    view = finder.findRequiredView(source, 2131492950, "field 'listView'");
    target.listView = finder.castView(view, 2131492950, "field 'listView'");
  }

  @Override public void unbind(T target) {
    target.dataFormatTextView = null;
    target.dataParsingMethodTextView = null;
    target.decodeTimeTextView = null;
    target.decodeButton = null;
    target.encodeTimeTextView = null;
    target.encodeButton = null;
    target.listView = null;
  }
}
