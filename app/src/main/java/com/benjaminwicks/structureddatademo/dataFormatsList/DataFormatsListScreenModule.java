package com.benjaminwicks.structureddatademo.dataFormatsList;

import com.benjaminwicks.structureddatademo.MainActivityModule;

import dagger.Module;

@Module(
        injects = {
                DataFormatsListView.class,
        },
        addsTo = MainActivityModule.class
)
final class DataFormatsListScreenModule {

}
