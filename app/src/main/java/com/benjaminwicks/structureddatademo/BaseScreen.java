package com.benjaminwicks.structureddatademo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.jaynewstrom.concrete.Concrete;
import com.jaynewstrom.concrete.ConcreteBlock;
import com.jaynewstrom.screenswitcher.Screen;

public abstract class BaseScreen implements Screen, ConcreteBlock {

    @Override public View createView(@NonNull Context context) {
        Context childContext = Concrete.findWall(context).stack(this).createContext(context);
        return createViewWithConcreteContext(childContext);
    }

    protected abstract View createViewWithConcreteContext(@NonNull Context context);

    @Override public void destroyScreen(@NonNull View viewToDestroy) {
        Concrete.findWall(viewToDestroy.getContext()).destroy();
    }
}
