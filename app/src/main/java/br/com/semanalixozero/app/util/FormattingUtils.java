package br.com.semanalixozero.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static android.text.format.DateUtils.SECOND_IN_MILLIS;
import static android.text.format.DateUtils.getRelativeTimeSpanString;

/**
 * @author Filipe Bezerra
 */
public class FormattingUtils {

    private FormattingUtils() {/* cannot be instantiated */}

    public static String formatTime(final String format, final long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return dateFormat.format(calendar.getTime());
    }

    public static CharSequence getRelativeTimeToNow(final long time) {
        return getRelativeTimeSpanString(time, System.currentTimeMillis(), SECOND_IN_MILLIS);
    }
}
