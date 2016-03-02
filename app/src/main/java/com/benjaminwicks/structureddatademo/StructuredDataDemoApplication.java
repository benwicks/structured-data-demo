package com.benjaminwicks.structureddatademo;

import android.app.Application;

import com.jaynewstrom.concrete.Concrete;
import com.jaynewstrom.concrete.ConcreteWall;

public final class StructuredDataDemoApplication extends Application {

    private ConcreteWall foundation;

    @Override public void onCreate() {
        super.onCreate();
        foundation = Concrete.pourFoundation(new ApplicationModule(this), BuildConfig.DEBUG);
    }

    @Override public Object getSystemService(String name) {
        if (Concrete.isService(name)) {
            return foundation;
        }
        return super.getSystemService(name);
    }
}
