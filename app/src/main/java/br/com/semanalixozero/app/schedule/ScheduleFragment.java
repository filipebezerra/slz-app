package br.com.semanalixozero.app.schedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.List;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;
import butterknife.BindView;

import static br.com.semanalixozero.app.schedule.ScheduleDayPagerAdapter.createAdapter;
import static br.com.semanalixozero.app.util.FeedbackHelper.showLongPeriodFeedback;
import static com.getkeepsafe.taptargetview.TapTarget.forView;

/**
 * @author Filipe Bezerra
 */
public class ScheduleFragment extends BaseFragment implements ScheduleContract.View {

    public static ScheduleFragment create() {
        return new ScheduleFragment();
    }

    private ScheduleContract.Presenter presenter;
    private ScheduleDayPagerAdapter scheduleAdapter;

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_schedule;
    }

    @Nullable @Override public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle inState) {
        return initializeView(super.onCreateView(inflater, container, inState));
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new SchedulePresenter(this);
        presenter.loadSchedules();
    }

    @Override public void showSchedules(List<Schedule> schedules) {
        scheduleAdapter.setSchedules(schedules);
        //TODO: Fix tabLayout indicator update
        //viewPager.setCurrentItem(presenter.getToday(), true);
    }

    @Override public void displayScheduleDiscovery() {
        TapTargetView.showFor(getActivity(), createTabTapTarget(),
                new TapTargetView.Listener(){
                    @Override public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);
                        presenter.clickUserDiscoveredSchedule();
                    }

                    @Override public void onTargetCancel(TapTargetView view) {
                        super.onTargetCancel(view);
                        presenter.clickUserCancelledScheduleDiscovery();
                    }
                });
    }

    @Override public void displayScheduleDiscoveryExplanation() {
        showLongPeriodFeedback(getCoordinatorLayout(), R.string.message_discovery_explanation);
    }

    private View initializeView(@Nullable View view) {
        if (view != null) {
            scheduleAdapter = createAdapter(getChildFragmentManager());
            viewPager.setAdapter(scheduleAdapter);

            tabLayout.addOnTabSelectedListener(
                    new TabLayout.ViewPagerOnTabSelectedListener(viewPager){
                        @Override public void onTabSelected(TabLayout.Tab tab) {
                            super.onTabSelected(tab);
                            presenter.checkCanDisplayScheduleDiscovery(tab.getPosition());
                        }
                    });
            //tabLayout.setTypeface(obtainTypeface(getContext(), TYPEFACE_ROBOTO_LIGHT));
            tabLayout.setupWithViewPager(viewPager);
        }
        return view;
    }

    private TapTarget createTabTapTarget() {
        LinearLayout tabView = (LinearLayout) ((LinearLayout)
                tabLayout.getChildAt(0)).getChildAt(viewPager.getCurrentItem());

        return forView(tabView, getString(R.string.title_schedule_discovery),
                getString(R.string.description_schedule_discovery)).transparentTarget(true);
    }
}
