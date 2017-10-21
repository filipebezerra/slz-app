package br.com.semanalixozero.app.recyclerview;

import android.view.View;

/**
 * @author Filipe Bezerra
 */
public interface OnItemTouchListener {

    void onSingleTapUp(View view, int position);

    void onLongPress(View view, int position);
}
