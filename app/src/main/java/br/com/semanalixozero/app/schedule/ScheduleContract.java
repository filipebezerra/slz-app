package br.com.semanalixozero.app.schedule;

import java.util.List;

/**
 * @author Filipe Bezerra
 */
interface ScheduleContract {

    interface View {

        void showSchedules(List<Schedule> schedules);

        void displayScheduleDiscovery();

        void displayScheduleDiscoveryExplanation();
    }

    interface Presenter {

        void loadSchedules();

        //TODO: Fix tabLayout indicator update
        //int getToday();

        void checkCanDisplayScheduleDiscovery(int tabPosition);

        void clickUserDiscoveredSchedule();

        void clickUserCancelledScheduleDiscovery();
    }
}
