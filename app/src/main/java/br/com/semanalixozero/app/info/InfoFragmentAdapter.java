package br.com.semanalixozero.app.info;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.aboutevent.AboutEventFragment;
import br.com.semanalixozero.app.aboutus.AboutUsFragment;
import br.com.semanalixozero.app.cities.CitiesFragment;
import br.com.semanalixozero.app.contact.ContactFragment;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * @author Filipe Bezerra
 */
class InfoFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    private List<String> titles;

    private InfoFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        initialize(context);
    }

    static InfoFragmentAdapter createAdapter(
            @NonNull final FragmentManager fm, @NonNull final Context context) {
        return new InfoFragmentAdapter(fm, context);
    }

    private void initialize(Context context) {
        fragments = unmodifiableList(asList(
                AboutEventFragment.create(),
                AboutUsFragment.create(),
                ContactFragment.create(),
                CitiesFragment.create()));

        titles = unmodifiableList(asList(
                context.getResources().getStringArray(R.array.titles_tab_info)));
    }

    @Override public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override public int getCount() {
        return fragments.size();
    }

    @Override public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
