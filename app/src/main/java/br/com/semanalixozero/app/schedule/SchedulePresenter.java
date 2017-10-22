package br.com.semanalixozero.app.schedule;

import java.util.List;

/**
 * @author Filipe Bezerra
 */
class SchedulePresenter implements ScheduleContract.Presenter {

    private final ScheduleContract.View view;
    private List<Schedule> schedules;

    SchedulePresenter(ScheduleContract.View view) {
        this.view = view;
    }

    @Override public void loadSchedules() {
        schedules = MockScheduleDataset.getSchedules();
        view.showSchedules(schedules);
    }
}
