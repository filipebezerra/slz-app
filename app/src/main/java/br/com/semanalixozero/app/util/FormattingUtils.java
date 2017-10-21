package br.com.semanalixozero.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author Filipe Bezerra
 */
public class FormattingUtils {

    private FormattingUtils() {/* cannot be instantiated */}

    public static String formatDateTime(final String format, final long millis) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return dateFormat.format(calendar.getTime());
    }
}
