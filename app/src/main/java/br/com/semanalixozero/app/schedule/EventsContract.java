package br.com.semanalixozero.app.schedule;

import java.util.List;

/**
 * @author Filipe Bezerra
 */
interface EventsContract {

    interface View {

        void showEvents(List<Event> events);
    }

    interface Presenter {

    }
}
