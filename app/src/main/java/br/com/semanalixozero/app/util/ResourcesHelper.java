package br.com.semanalixozero.app.util;

import android.content.Context;
import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.semanalixozero.app.R;

/**
 * @author Filipe Bezerra
 */
public class ResourcesHelper {

    private ResourcesHelper() {}

    private static int[] paletteColors;

    public static List<Integer> getPaletteColors(final Context context) {
        if (paletteColors == null) {
            paletteColors = context.getResources().getIntArray(R.array.palette_colors);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Arrays.stream(paletteColors).boxed().collect(Collectors.toList());
        } else {
            List<Integer> paletteColorList = new ArrayList<>();
            for (int paletteColor : paletteColors) {
                paletteColorList.add(paletteColor);
            }
            return paletteColorList;
        }
    }
}
