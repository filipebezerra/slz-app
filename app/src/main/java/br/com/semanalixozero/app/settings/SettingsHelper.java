package br.com.semanalixozero.app.settings;

/**
 * @author Filipe Bezerra
 */
public interface SettingsHelper {

    void setUserDiscoveredSchedule();

    boolean isUserDiscoveredSchedule();

    void setUserDiscoveredEventDetails();

    boolean isUserDiscoveredEventDetails();
}
