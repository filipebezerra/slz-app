package br.com.semanalixozero.app.schedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;
import br.com.semanalixozero.app.event.EventsFragment;
import br.com.semanalixozero.app.view.TabsFragmentAdapter;
import butterknife.BindView;

import static br.com.semanalixozero.app.util.FormattingUtils.formatDateTime;
import static br.com.semanalixozero.app.view.TabsFragmentAdapter.createAdapter;

/**
 * @author Filipe Bezerra
 */
public class ScheduleFragment extends BaseFragment implements ScheduleContract.View {

    public static ScheduleFragment create() {
        return new ScheduleFragment();
    }

    private TabsFragmentAdapter fragmentAdapter;

    private ScheduleContract.Presenter presenter;

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_schedule;
    }

    @Nullable @Override public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle inState) {
        final View view = super.onCreateView(inflater, container, inState);
        setupViewPager();
        setupNavigationTab();
        return view;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new SchedulePresenter(this);
    }

    private void setupViewPager() {
        fragmentAdapter = createAdapter(getChildFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
    }

    private void setupNavigationTab() {
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setTypeface(obtainTypeface(getContext(), TYPEFACE_ROBOTO_LIGHT));
    }

    @Override public void showSchedules(List<Schedule> schedules) {
        for(Schedule schedule : schedules) {
            final String scheduleDate = formatDateTime("EEE dd/MM", schedule.getTimestamp());
            fragmentAdapter.add(EventsFragment.create(schedule.getEvents()), scheduleDate);
        }
    }
}
