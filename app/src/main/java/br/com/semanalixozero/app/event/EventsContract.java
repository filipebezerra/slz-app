package br.com.semanalixozero.app.event;

import java.util.List;

/**
 * @author Filipe Bezerra
 */
interface EventsContract {

    interface View {

        void showEvents(List<Event> events);

        void navigateToEventDetail(Event selectedEvent);
    }

    interface Presenter {

        void clickOnEvent(int position);
    }
}
