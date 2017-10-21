package br.com.semanalixozero.app.schedule;

import java.util.List;

/**
 * @author Filipe Bezerra
 */
public class Schedule {

    private Long timestamp;
    private List<Event> events;

    public Schedule(Long timestamp, List<Event> events) {
        this.timestamp = timestamp;
        this.events = events;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public List<Event> getEvents() {
        return events;
    }
}
