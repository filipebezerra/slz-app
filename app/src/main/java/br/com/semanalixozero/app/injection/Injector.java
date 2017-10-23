package br.com.semanalixozero.app.injection;

import android.content.Context;

import br.com.semanalixozero.app.settings.SettingsHelper;
import br.com.semanalixozero.app.settings.SettingsHelperImpl;

import static br.com.semanalixozero.app.BaseApplication.getApplicationInstance;

/**
 * @author Filipe Bezerra
 */
public class Injector {

    private Injector() {/* No instances */}

    public static Context provideApplicationContext() {
        return getApplicationInstance();
    }

    private static SettingsHelper settingsHelper;

    public static SettingsHelper provideSettings() {
        if (settingsHelper == null) {
            settingsHelper = new SettingsHelperImpl();
        }
        return settingsHelper;
    }
}
