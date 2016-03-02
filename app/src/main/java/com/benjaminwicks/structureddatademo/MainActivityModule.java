package com.benjaminwicks.structureddatademo;

import com.benjaminwicks.structureddatademo.dataFormatsList.DataFormatsListScreen;
import com.jaynewstrom.screenswitcher.Screen;
import com.jaynewstrom.screenswitcher.ScreenSwitcherState;

import java.util.Collections;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                MainActivity.class,
        },
        addsTo = ApplicationModule.class
)
public final class MainActivityModule {

    @Provides @Singleton ScreenManager provideScreenManager(ScreenSwitcherState screenSwitcherState) {
        return new ScreenManager(screenSwitcherState);
    }

    @Provides @Singleton ScreenSwitcherState provideScreenSwitcherState() {
        return new ScreenSwitcherState(Collections.<Screen>singletonList(new DataFormatsListScreen()));
    }
}
