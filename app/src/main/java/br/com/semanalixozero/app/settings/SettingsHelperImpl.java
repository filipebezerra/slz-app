package br.com.semanalixozero.app.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;
import static android.support.v4.content.SharedPreferencesCompat.EditorCompat.getInstance;
import static br.com.semanalixozero.app.injection.Injector.provideApplicationContext;

/**
 * @author Filipe Bezerra
 */
public class SettingsHelperImpl implements SettingsHelper {

    private static final String SETTING_USER_DISCOVERED_SCHEDULE =
            "setting.user-discovered-schedule";

    private static final String SETTING_USER_DISCOVERED_EVENT_DETAILS =
            "setting.user-discovered-event_details";

    private SharedPreferences sharedPreferences;

    public SettingsHelperImpl() {
        sharedPreferences = getDefaultSharedPreferences(provideApplicationContext());
    }

    @SuppressLint("CommitPrefEdits") @Override public void setUserDiscoveredSchedule() {
        getInstance().apply(sharedPreferences
                .edit()
                .putBoolean(SETTING_USER_DISCOVERED_SCHEDULE, true));
    }

    @Override public boolean isUserDiscoveredSchedule() {
        return sharedPreferences.getBoolean(SETTING_USER_DISCOVERED_SCHEDULE, false);
    }

    @SuppressLint("CommitPrefEdits") @Override public void setUserDiscoveredEventDetails() {
        getInstance().apply(sharedPreferences
                .edit()
                .putBoolean(SETTING_USER_DISCOVERED_EVENT_DETAILS, true));
    }

    @Override public boolean isUserDiscoveredEventDetails() {
        return sharedPreferences.getBoolean(SETTING_USER_DISCOVERED_EVENT_DETAILS, false);
    }
}
