package br.com.semanalixozero.app.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Filipe Bezerra
 */
public class ItemTouchListenerImpl extends RecyclerView.SimpleOnItemTouchListener {

    @NonNull private RecyclerView recyclerView;
    @NonNull private GestureDetector gestureDetector;
    @NonNull private OnItemTouchListener clickListener;

    public ItemTouchListenerImpl(
            @NonNull Context context, @NonNull RecyclerView recyclerView,
            @NonNull OnItemTouchListener clickListener) {
        this.recyclerView = recyclerView;
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    @Override public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetector.onTouchEvent(e);
        return false;
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            notifyEvent(e, true);
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            notifyEvent(e, false);
        }

        private void notifyEvent(MotionEvent e, boolean isClick) {
            final View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
            final int position = recyclerView.getChildAdapterPosition(child);

            if (isClick) {
                clickListener.onSingleTapUp(child, position);
            } else {
                clickListener.onLongPress(child, position);
            }
        }
    }
}
