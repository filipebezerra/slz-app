package br.com.semanalixozero.app.schedule;

import java.util.List;

/**
 * @author Filipe Bezerra
 */
interface ScheduleContract {

    interface View {

        void showSchedules(List<Schedule> schedules);
    }

    interface Presenter {


    }
}
