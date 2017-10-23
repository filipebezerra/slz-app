package br.com.semanalixozero.app.schedule;

import java.util.List;

import static br.com.semanalixozero.app.injection.Injector.provideSettings;

/**
 * @author Filipe Bezerra
 */
class SchedulePresenter implements ScheduleContract.Presenter {

    private final ScheduleContract.View view;

    private List<Schedule> schedules;

    //TODO: Fix tabLayout indicator update
    //private int today = 0;

    SchedulePresenter(ScheduleContract.View view) {
        this.view = view;
    }

    @Override public void loadSchedules() {
        schedules = MockScheduleDataset.getSchedules();

        //TODO: Fix tabLayout indicator update
        /*for (int i = 0; i < schedules.size(); i++) {
           if (DateUtils.isToday(schedules.get(i).getTimestamp())) {
               today = i;
           }
        }*/

        view.showSchedules(schedules);
    }

    //TODO: Fix tabLayout indicator update
    /*@Override public int getToday() {
        return today;
    }*/

    @Override public void checkCanDisplayScheduleDiscovery(int tabPosition) {
        //TODO: Fix tabLayout indicator update
        if (/*tabPosition != today || */provideSettings().isUserDiscoveredSchedule())
            return;

        view.displayScheduleDiscovery();
    }

    @Override public void clickUserDiscoveredSchedule() {
        provideSettings().setUserDiscoveredSchedule();
    }

    @Override public void clickUserCancelledScheduleDiscovery() {
        view.displayScheduleDiscoveryExplanation();
    }
}
