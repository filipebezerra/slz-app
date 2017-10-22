package br.com.semanalixozero.app.schedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;
import butterknife.BindView;

import static br.com.semanalixozero.app.schedule.ScheduleDayPagerAdapter.createAdapter;

/**
 * @author Filipe Bezerra
 */
public class ScheduleFragment extends BaseFragment implements ScheduleContract.View {

    public static ScheduleFragment create() {
        return new ScheduleFragment();
    }

    private ScheduleContract.Presenter presenter;

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_schedule;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new SchedulePresenter(this);
        presenter.loadSchedules();
    }

    @Override public void showSchedules(List<Schedule> schedules) {
        ScheduleDayPagerAdapter adapter = createAdapter(getChildFragmentManager(), schedules);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(adapter.getToday(), true);
        //tabLayout.setTypeface(obtainTypeface(getContext(), TYPEFACE_ROBOTO_LIGHT));
        tabLayout.setupWithViewPager(viewPager);
    }
}
