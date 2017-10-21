package br.com.semanalixozero.app.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filipe Bezerra
 */
public class TabsFragmentAdapter extends FragmentAdapter {

    protected List<String> fragmentTitles = new ArrayList<>();

    public static TabsFragmentAdapter createAdapter(FragmentManager fragmentManager) {
        return new TabsFragmentAdapter(fragmentManager);
    }

    protected TabsFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public TabsFragmentAdapter add(final Fragment newFragment, final String title) {
        fragments.add(newFragment);
        fragmentTitles.add(title);
        notifyDataSetChanged();
        return this;
    }

    public TabsFragmentAdapter add(final List<Fragment> newFragments, final List<String> titles) {
        fragments.addAll(newFragments);
        fragmentTitles.addAll(titles);
        notifyDataSetChanged();
        return this;
    }

    @Override public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }
}
