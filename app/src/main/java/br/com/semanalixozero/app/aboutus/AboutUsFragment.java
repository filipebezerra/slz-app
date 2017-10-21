package br.com.semanalixozero.app.aboutus;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.view.View;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;
import butterknife.OnClick;

import static android.support.v4.content.ContextCompat.getColor;

/**
 * @author Filipe Bezerra
 */
public class AboutUsFragment extends BaseFragment implements AboutUsContract.View {

    public static AboutUsFragment create() {
        return new AboutUsFragment();
    }

    private AboutUsContract.Presenter presenter;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_about_us;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new AboutUsPresenter(this);
    }

    @OnClick(R.id.button_visit_ilzb_site) void onClickButtonVisitIlzbSite() {
        presenter.clickButtonVisitIlzbSite();
    }

    @OnClick(R.id.button_visit_srz_site) void onClickButtonVisitSrzSite() {
        presenter.clickButtonVisitSrzSite();
    }

    @Override public void openSite(String uriString) {
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                .setToolbarColor(getColor(getContext(), R.color.primary))
                .setShowTitle(true)
                .build();
        customTabsIntent.launchUrl(getContext(), Uri.parse(uriString));
    }
}
