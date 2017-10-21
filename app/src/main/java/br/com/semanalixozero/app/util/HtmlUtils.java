package br.com.semanalixozero.app.util;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import timber.log.Timber;

/**
 * @author Filipe Bezerra
 */
public class HtmlUtils {

    private static Html.TagHandler sTagHandler;

    private HtmlUtils() {/* cannot be instantiated */}

    public static void renderHtml(@NonNull String source, @NonNull TextView target) {
        if (sTagHandler == null) {
            sTagHandler = (opening, tag, output, xmlReader)
                    -> Timber.i("HTML %s tag not interpreted", tag);
        }

        Spanned html;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            html = Html.fromHtml(
                    source, Html.FROM_HTML_MODE_LEGACY, null, sTagHandler);
        } else {
            //noinspection deprecation
            html = Html.fromHtml(source, null, sTagHandler);
        }

        target.setText(html);
        target.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
