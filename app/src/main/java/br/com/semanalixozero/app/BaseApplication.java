package br.com.semanalixozero.app;

import android.app.Application;

/**
 * @author Filipe Bezerra
 */
public abstract class BaseApplication extends Application {

    private static BaseApplication applicationInstance;

    @Override public void onCreate() {
        super.onCreate();
        applicationInstance = this;
        initializeLogging();
    }

    public static BaseApplication getApplicationInstance() {
        return applicationInstance;
    }

    protected abstract void initializeLogging();
}
