package com.benjaminwicks.structureddatademo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.NonNull;
import android.view.View;

import com.jaynewstrom.screenswitcher.ScreenTransition;

public final class DefaultScreenTransition implements ScreenTransition {

    public static final DefaultScreenTransition INSTANCE = new DefaultScreenTransition();

    public DefaultScreenTransition() {
    }

    @Override public void transitionIn(@NonNull View foregroundView, @NonNull View backgroundView,
            @NonNull final Runnable onTransitionCompleted) {
        foregroundView.setX(((View) foregroundView.getParent()).getMeasuredWidth());
        foregroundView.animate()
                      .x(0)
                      .setDuration(300)
                      .setListener(new AnimatorListenerAdapter() {
                          @Override public void onAnimationEnd(Animator animation) {
                              onTransitionCompleted.run();
                          }
                      });
    }

    @Override public void transitionOut(@NonNull View foregroundView, @NonNull View backgroundView,
            @NonNull final Runnable onTransitionCompleted) {
        foregroundView.animate()
                      .x(((View) foregroundView.getParent()).getMeasuredWidth())
                      .setDuration(300)
                      .setListener(new AnimatorListenerAdapter() {
                          @Override public void onAnimationEnd(Animator animation) {
                              onTransitionCompleted.run();
                          }
                      });
    }
}
