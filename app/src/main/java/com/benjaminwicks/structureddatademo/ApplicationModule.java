package com.benjaminwicks.structureddatademo;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(
        library = true
)
public final class ApplicationModule {

    private final Application application;

    ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides @ForApplication Context provideApplicationContext() {
        return application;
    }

    @Provides @Singleton Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://192.168.1.223")
                .addConverterFactory(CustomRequestHeaderWireConverterFactory.create())
                .build();
    }
}