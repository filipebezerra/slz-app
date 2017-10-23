package br.com.semanalixozero.app.util;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import br.com.semanalixozero.app.R;

import static android.support.design.widget.Snackbar.make;
import static android.support.v4.content.ContextCompat.getColor;

/**
 * @author Filipe Bezerra
 */
public class FeedbackHelper {

    private FeedbackHelper() {/* cannot be instantiated */}

    public static void showLongPeriodFeedback(@NonNull View view, @StringRes int message) {
        showSnackbar(view, message, false);
    }

    private static void showSnackbar(@NonNull View view, @StringRes int message, boolean quickly) {
        final Snackbar snackbar = make(view, message,
                quickly ? Snackbar.LENGTH_SHORT : Snackbar.LENGTH_LONG);
        final View snackbarView = snackbar.getView();

        snackbarView.setBackgroundColor(getColor(view.getContext(), R.color.dark_blue));

        final TextView textView =
                snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(getColor(view.getContext(), android.R.color.white));

        snackbar.show();
    }
}
