package com.benjaminwicks.structureddatademo;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

    @Provides @Singleton Picasso providePicasso(@ForApplication final Context context) {
        Picasso.Builder builder = new Picasso.Builder(context);

        if (BuildConfig.DEBUG) {
            builder.listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                    Log.e("Picasso Failed on uri: ", uri.toString());
                }
            });
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Runtime info = Runtime.getRuntime();
            long availableBytes = info.maxMemory() - info.totalMemory() + info.freeMemory();
            builder.memoryCache(new LruCache((int) (availableBytes / 4)));
        }

        builder.downloader(new OkHttp3Downloader(context));

        return builder.build();
    }
}