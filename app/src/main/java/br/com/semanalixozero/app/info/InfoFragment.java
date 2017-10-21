package br.com.semanalixozero.app.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.aboutevent.AboutEventFragment;
import br.com.semanalixozero.app.aboutus.AboutUsFragment;
import br.com.semanalixozero.app.base.BaseFragment;
import br.com.semanalixozero.app.cities.CitiesFragment;
import br.com.semanalixozero.app.contact.ContactFragment;
import br.com.semanalixozero.app.view.TabsFragmentAdapter;
import butterknife.BindArray;
import butterknife.BindView;

import static br.com.semanalixozero.app.view.TabsFragmentAdapter.createAdapter;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * @author Filipe Bezerra
 */
public class InfoFragment extends BaseFragment implements InfoContract.View {

    public static InfoFragment create() {
        return new InfoFragment();
    }

    private static final List<Fragment> FRAGMENTS;

    static {
        FRAGMENTS = unmodifiableList(asList(
                AboutEventFragment.create(),
                AboutUsFragment.create(),
                ContactFragment.create(),
                CitiesFragment.create()
        ));
    }

    @BindArray(R.array.titles_tab_info) String[] tabTitles;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_info;
    }

    @Nullable @Override public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle inState) {
        final View view = super.onCreateView(inflater, container, inState);
        setupViewPager();
        setupNavigationTab();
        return view;
    }

    private void setupViewPager() {
        TabsFragmentAdapter fragmentAdapter = createAdapter(getChildFragmentManager())
                .add(FRAGMENTS, asList(tabTitles));
        viewPager.setAdapter(fragmentAdapter);
    }

    private void setupNavigationTab() {
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setTypeface(obtainTypeface(getContext(), TYPEFACE_ROBOTO_LIGHT));
    }
}
