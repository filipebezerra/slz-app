package br.com.semanalixozero.app.aboutevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;

/**
 * @author Filipe Bezerra
 */
public class AboutEventFragment extends BaseFragment implements AboutEventContract.View {

    public static AboutEventFragment create() {
        return new AboutEventFragment();
    }

    private AboutEventContract.Presenter presenter;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_about_event;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new AboutEventPresenter(this);
    }
}
