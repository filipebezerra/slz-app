package br.com.semanalixozero.app.schedule;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import java.util.List;

import br.com.semanalixozero.app.event.EventsFragment;

import static android.text.format.DateUtils.isToday;
import static br.com.semanalixozero.app.event.EventsFragment.create;
import static br.com.semanalixozero.app.util.FormattingUtils.formatTime;

/**
 * @author Filipe Bezerra
 */
class ScheduleDayPagerAdapter extends FragmentPagerAdapter {

    private SparseArray<EventsFragment> fragments = new SparseArray<>();
    private SparseArray<String> titles = new SparseArray<>();

    private int today = 0;

    private ScheduleDayPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    static ScheduleDayPagerAdapter createAdapter(@NonNull final FragmentManager fm) {
        return new ScheduleDayPagerAdapter(fm);
    }

    void setSchedules(@NonNull final List<Schedule> schedules) {
        initialize(schedules);
    }

    private void initialize(List<Schedule> schedules) {
        int count;
        for(Schedule schedule : schedules) {
            EventsFragment eventsFragment = create(schedule.getEvents());
            String scheduleDate = formatTime("EEE dd/MM", schedule.getTimestamp());

            count = fragments.size();
            fragments.put(count, eventsFragment);
            titles.put(count, scheduleDate);

            if (isToday(schedule.getTimestamp())) {
                today = count;
            }
        }
        notifyDataSetChanged();
    }

    @Override public EventsFragment getItem(int position) {
        if (fragments != null && fragments.size() > position && fragments.get(position) != null) {
            return fragments.get(position);
        }
        return new EventsFragment();
    }

    @Override public int getCount() {
        if (fragments != null) {
            return fragments.size();
        }
        return 0;
    }

    @Override public CharSequence getPageTitle(int position) {
        if (titles != null && titles.size() > position && titles.get(position) != null) {
            return titles.get(position);
        }
        return "";
    }

    int getToday() {
        return today;
    }
}
