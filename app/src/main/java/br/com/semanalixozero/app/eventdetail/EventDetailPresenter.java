package br.com.semanalixozero.app.eventdetail;

import br.com.semanalixozero.app.event.Event;

import static br.com.semanalixozero.app.injection.Injector.provideSettings;
import static br.com.semanalixozero.app.util.FormattingUtils.formatTime;

/**
 * @author Filipe Bezerra
 */
class EventDetailPresenter implements EventDetailContract.Presenter {

    private final EventDetailContract.View view;
    private final Event event;

    EventDetailPresenter(EventDetailContract.View view, Event event) {
        this.view = view;
        this.event = event;
        showEventDetails();
    }

    @Override public void clickFab() {
        view.openSite(event.getLink());
    }

    @Override public void clickMenuShowLocation() {
        view.openMap(event.getAddress());
    }

    @Override public boolean canOpenMap() {
        return !event.getAddress().isEmpty();
    }

    @Override public void clickMenuShareEvent() {
        String content = new StringBuilder("Confira ")
                .append("\"")
                .append(event.getTitle())
                .append("\" ")
                .append("em ")
                .append("#slz ")
                .append(event.getLink())
                .toString();
        view.shareContent(content);
    }

    @Override public void checkCanDisplayEventDetailsDiscovery() {
        if (provideSettings().isUserDiscoveredEventDetails())
            return;

        view.displayEventDetailsDiscovery();
    }

    @Override public void clickUserDiscoveredEventDetails() {
        provideSettings().setUserDiscoveredEventDetails();
    }

    @Override public void clickUserCancelledEventDetailsDiscovery() {
        view.displayEventDetailsDiscoveryExplanation();
    }

    private void showEventDetails() {
        final String startsAt = formatTime("EEE, \'das\' HH\'h\'mm", event.getStartsAt());
        final String endsAt = formatTime("\'às\' HH\'h\'mm", event.getEndsAt());

        view.showEventTitle(event.getTitle());
        view.showEventPlaceName(event.getPlaceName());
        view.showEventDescription(event.getDescription());
        view.showEventTime(startsAt, endsAt);
    }
}
