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

    private final DataFormat dataFormat;
    private final DataParsingMethod dataParsingMethod;

    DataFormatDetailsModule(DataFormat dataFormat, DataParsingMethod dataParsingMethod) {
        this.dataFormat = dataFormat;
        this.dataParsingMethod = dataParsingMethod;
    }

    @Provides @Singleton DataFormat provideDataFormat() {
        return dataFormat;
    }

    @Provides @Singleton DataParsingMethod provideDataParsingMethod() {
        return dataParsingMethod;
    }
}
