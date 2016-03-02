package com.benjaminwicks.structureddatademo.dataFormatDetails;

import com.benjaminwicks.structureddatademo.MainActivityModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                DataFormatDetailsView.class,
        },
        addsTo = MainActivityModule.class
)
final class DataFormatDetailsModule {

    private final DataParsingMethod dataParsingMethod;

    DataFormatDetailsModule(DataParsingMethod dataParsingMethod) {
        this.dataParsingMethod = dataParsingMethod;
    }

    @Provides @Singleton DataParsingMethod provideDataParsingMethod() {
        return dataParsingMethod;
    }
}
