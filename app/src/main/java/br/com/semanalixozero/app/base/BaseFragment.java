package br.com.semanalixozero.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Filipe Bezerra
 */
public abstract class BaseFragment extends Fragment {

    private BaseActivity hostActivity;

    private Unbinder unbinder;

    public BaseFragment() {}

    @LayoutRes protected abstract int fragmentViewResource();

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        try {
            hostActivity = (BaseActivity) context;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Descendants of " + getClass().getName() +
                    " must be hosted by " + BaseActivity.class.getName());
        }
    }

    @Nullable @Override public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle inState) {
        final View fragmentView = inflater.inflate(fragmentViewResource(), container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    public CoordinatorLayout getCoordinatorLayout() {
        return hostActivity.getCoordinatorLayout();
    }
}