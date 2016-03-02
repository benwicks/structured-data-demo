package com.benjaminwicks.structureddatademo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.jaynewstrom.concrete.Concrete;
import com.jaynewstrom.concrete.ConcreteWall;
import com.jaynewstrom.screenswitcher.ScreenSwitcher;
import com.jaynewstrom.screenswitcher.ScreenSwitcherFactory;
import com.jaynewstrom.screenswitcher.ScreenSwitcherState;

import javax.inject.Inject;

public final class MainActivity extends AppCompatActivity {

    @Inject ScreenManager screenManager;
    @Inject ScreenSwitcherState screenSwitcherState;

    private ConcreteWall activityConcreteWall;
    private ScreenSwitcher activityScreenSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityConcreteWall = Concrete.findWall(getApplicationContext()).stack(new MainActivityConcreteBlock());
        Concrete.inject(this, this);
        activityScreenSwitcher = ScreenSwitcherFactory.activityScreenSwitcher(this, screenSwitcherState);
        screenManager.take(activityScreenSwitcher);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        screenManager.drop(activityScreenSwitcher);
        if (isFinishing()) {
            activityConcreteWall.destroy();
        }
    }

    @Override public boolean dispatchTouchEvent(MotionEvent ev) {
        return activityScreenSwitcher.isTransitioning() || super.dispatchTouchEvent(ev);
    }

    @Override public void onBackPressed() {
        if (!activityScreenSwitcher.isTransitioning()) {
            screenManager.pop();
        }
    }

    @Override public Object getSystemService(@NonNull String name) {
        if (Concrete.isService(name)) {
            return activityConcreteWall;
        }
        return super.getSystemService(name);
    }
}
