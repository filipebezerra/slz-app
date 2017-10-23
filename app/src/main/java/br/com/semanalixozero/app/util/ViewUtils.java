package br.com.semanalixozero.app.util;

import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * @author Filipe Bezerra
 */
public class ViewUtils {

    private ViewUtils() {/* cannot be instantiated */}

    /**
     * Executes the given {@link java.lang.Runnable} when the view is laid out
     **/
    public static void onLaidOut(final View view, final Runnable runnable) {
        if (isLaidOut(view)) {
            runnable.run();
            return;
        }

        final ViewTreeObserver observer = view.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                final ViewTreeObserver trueObserver;

                if (observer.isAlive()) {
                    trueObserver = observer;
                } else {
                    trueObserver = view.getViewTreeObserver();
                }

                removeOnGlobalLayoutListener(trueObserver, this);

                runnable.run();
            }
        });
    }

    /**
     * Returns whether or not the view has been laid out
     **/
    private static boolean isLaidOut(View view) {
        return ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0;
    }

    @SuppressWarnings("deprecation") private static void removeOnGlobalLayoutListener(
            ViewTreeObserver observer, ViewTreeObserver.OnGlobalLayoutListener listener) {
        if (Build.VERSION.SDK_INT >= 16) {
            observer.removeOnGlobalLayoutListener(listener);
        } else {
            observer.removeGlobalOnLayoutListener(listener);
        }
    }
}
