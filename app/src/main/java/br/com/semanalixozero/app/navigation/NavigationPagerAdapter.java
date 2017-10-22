package br.com.semanalixozero.app.navigation;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import br.com.semanalixozero.app.info.InfoFragment;
import br.com.semanalixozero.app.schedule.ScheduleFragment;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * @author Filipe Bezerra
 */
class NavigationPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    private NavigationPagerAdapter(FragmentManager fm) {
        super(fm);
        initialize();
    }

    static NavigationPagerAdapter createAdapter(@NonNull final FragmentManager fm) {
        return new NavigationPagerAdapter(fm);
    }

    private void initialize() {
        fragments = unmodifiableList(asList(ScheduleFragment.create(), InfoFragment.create()));
    }

    @Override public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override public int getCount() {
        return fragments.size();
    }
}