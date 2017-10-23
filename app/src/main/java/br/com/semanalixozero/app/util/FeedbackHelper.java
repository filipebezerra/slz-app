package br.com.semanalixozero.app.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.semanalixozero.app.R;

import static android.support.design.widget.Snackbar.make;
import static android.support.v4.content.ContextCompat.getColor;
import static android.widget.Toast.makeText;

/**
 * @author Filipe Bezerra
 */
public class FeedbackHelper {

    private FeedbackHelper() {/* cannot be instantiated */}

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

    private static void showToast(@NonNull Context context, @StringRes int message, boolean quickly) {
        makeText(context, message, quickly ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG).show();
    }

    public static void showLongPeriodFeedback(@NonNull Fragment fragment, @StringRes int message) {
        final View fragmentView = fragment.getView();
        if (fragmentView != null) {
            showSnackbar(fragmentView, message, false);
        } else {
            showToast(fragment.getContext(), message, false);
        }
    }
}
