package br.com.semanalixozero.app.schedule;

import java.util.List;

/**
 * @author Filipe Bezerra
 */
class EventsPresenter implements EventsContract.Presenter {

    private EventsContract.View view;
    private List<Event> events;

    EventsPresenter(EventsContract.View view, List<Event> events) {
        this.view = view;
        this.events = events;
        view.showEvents(this.events);
    }
}
