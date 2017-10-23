package br.com.semanalixozero.app.util;

/**
 * @author Filipe Bezerra
 */
public class DateUtils {

    private DateUtils() {/* cannot be instantiated */}

    public static boolean isToday(long when) {
        return android.text.format.DateUtils.isToday(when);
    }
}
