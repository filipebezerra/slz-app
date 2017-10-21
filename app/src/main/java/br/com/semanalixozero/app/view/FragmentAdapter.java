package br.com.semanalixozero.app.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filipe Bezerra
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    protected List<Fragment> fragments = new ArrayList<>();

    public static FragmentAdapter createAdapter(final FragmentManager fragmentManager) {
        return new FragmentAdapter(fragmentManager);
    }

    protected FragmentAdapter(final FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override public Fragment getItem(final int position) {
        return fragments.get(position);
    }

    @Override public int getCount() {
        return fragments.size();
    }

    public FragmentAdapter add(final Fragment newFragment) {
        fragments.add(newFragment);
        notifyDataSetChanged();
        return this;
    }
}