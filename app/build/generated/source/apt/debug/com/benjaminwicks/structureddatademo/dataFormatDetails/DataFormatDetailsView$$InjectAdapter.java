// Code generated by dagger-compiler.  Do not edit.
package com.benjaminwicks.structureddatademo.dataFormatDetails;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

/**
 * A {@code Binding<DataFormatDetailsView>} implementation which satisfies
 * Dagger's infrastructure requirements including:
 *
 * Owning the dependency links between {@code DataFormatDetailsView} and its
 * dependencies.
 *
 * Being a {@code Provider<DataFormatDetailsView>} and handling creation and
 * preparation of object instances.
 *
 * Being a {@code MembersInjector<DataFormatDetailsView>} and handling injection
 * of annotated fields.
 */
public final class DataFormatDetailsView$$InjectAdapter extends Binding<DataFormatDetailsView>
    implements MembersInjector<DataFormatDetailsView> {
  private Binding<DataFormat> dataFormat;
  private Binding<DataParsingMethod> dataParsingMethod;
  private Binding<com.benjaminwicks.structureddatademo.ScreenManager> screenManager;

  public DataFormatDetailsView$$InjectAdapter() {
    super(null, "members/com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormatDetailsView", NOT_SINGLETON, DataFormatDetailsView.class);
  }

  /**
   * Used internally to link bindings/providers together at run time
   * according to their dependency graph.
   */
  @Override
  @SuppressWarnings("unchecked")
  public void attach(Linker linker) {
    dataFormat = (Binding<DataFormat>) linker.requestBinding("com.benjaminwicks.structureddatademo.dataFormatDetails.DataFormat", DataFormatDetailsView.class, getClass().getClassLoader());
    dataParsingMethod = (Binding<DataParsingMethod>) linker.requestBinding("com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod", DataFormatDetailsView.class, getClass().getClassLoader());
    screenManager = (Binding<com.benjaminwicks.structureddatademo.ScreenManager>) linker.requestBinding("com.benjaminwicks.structureddatademo.ScreenManager", DataFormatDetailsView.class, getClass().getClassLoader());
  }

  /**
   * Used internally obtain dependency information, such as for cyclical
   * graph detection.
   */
  @Override
  public void getDependencies(Set<Binding<?>> getBindings, Set<Binding<?>> injectMembersBindings) {
    injectMembersBindings.add(dataFormat);
    injectMembersBindings.add(dataParsingMethod);
    injectMembersBindings.add(screenManager);
  }

  /**
   * Injects any {@code @Inject} annotated fields in the given instance,
   * satisfying the contract for {@code Provider<DataFormatDetailsView>}.
   */
  @Override
  public void injectMembers(DataFormatDetailsView object) {
    object.dataFormat = dataFormat.get();
    object.dataParsingMethod = dataParsingMethod.get();
    object.screenManager = screenManager.get();
  }

}
