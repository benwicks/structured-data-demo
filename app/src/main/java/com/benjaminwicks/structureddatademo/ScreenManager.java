package com.benjaminwicks.structureddatademo;

import android.support.annotation.IntRange;

import com.jaynewstrom.screenswitcher.Screen;
import com.jaynewstrom.screenswitcher.ScreenPopListener;
import com.jaynewstrom.screenswitcher.ScreenSwitcher;
import com.jaynewstrom.screenswitcher.ScreenSwitcherState;

public final class ScreenManager {

    private ScreenSwitcher screenSwitcher;

    private final ScreenSwitcherState screenSwitcherState;

    ScreenManager(ScreenSwitcherState screenSwitcherState) {
        this.screenSwitcherState = screenSwitcherState;
    }

    private boolean isSameImplementation(ScreenSwitcher screenSwitcher) {
        return this.screenSwitcher == screenSwitcher;
    }

    void take(ScreenSwitcher screenSwitcher) {
        this.screenSwitcher = screenSwitcher;
    }

    void drop(ScreenSwitcher screenSwitcher) {
        if (isSameImplementation(screenSwitcher)) {
            this.screenSwitcher = null;
        }
    }

    public void registerPopListener(Screen screen, ScreenPopListener popListener) {
        screenSwitcherState.registerPopListener(screen, popListener);
    }

    private void pop(@IntRange(from = 1) int numberToPop) {
        if (screenSwitcher != null) {
            screenSwitcher.pop(numberToPop);
        }
    }

    public void pop() {
        pop(1);
    }

    public void push(Screen screen) {
        if (screenSwitcher != null) {
            screenSwitcher.push(screen);
        }
    }

    public void popTo(Screen screen) {
        pop(screenSwitcherState.screenCount() - screenSwitcherState.indexOf(screen) - 1);
    }
}
