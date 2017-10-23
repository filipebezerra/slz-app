package br.com.semanalixozero.app.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;

import br.com.semanalixozero.app.R;
import butterknife.BindView;

import static butterknife.ButterKnife.bind;

/**
 * @author Filipe Bezerra
 */
public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.coordinator) CoordinatorLayout coordinatorLayout;
    @BindView(R.id.toolbar) @Nullable Toolbar toolbar;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override protected void onCreate(@Nullable final Bundle inState) {
        super.onCreate(inState);
        setContentView(viewLayoutResource());
        bind(this);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public CoordinatorLayout getCoordinatorLayout() {
        return coordinatorLayout;
    }

    @LayoutRes protected abstract int viewLayoutResource();
}
