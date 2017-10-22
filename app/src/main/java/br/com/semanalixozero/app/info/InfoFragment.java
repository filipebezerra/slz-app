package br.com.semanalixozero.app.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;
import butterknife.BindView;

import static br.com.semanalixozero.app.info.InfoFragmentAdapter.createAdapter;

/**
 * @author Filipe Bezerra
 */
public class InfoFragment extends BaseFragment implements InfoContract.View {

    public static InfoFragment create() {
        return new InfoFragment();
    }

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_info;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager();
        setupTabs();
    }

    private void setupViewPager() {
        viewPager.setAdapter(createAdapter(getChildFragmentManager(), getContext()));
    }

    private void setupTabs() {
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setTypeface(obtainTypeface(getContext(), TYPEFACE_ROBOTO_LIGHT));
    }
}
