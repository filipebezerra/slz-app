package br.com.semanalixozero.app.eventdetail;

import br.com.semanalixozero.app.event.Event;

import static br.com.semanalixozero.app.injection.Injector.provideSettings;
import static br.com.semanalixozero.app.util.FormattingUtils.formatTime;
import static br.com.semanalixozero.app.util.StringUtils.isNullOrEmpty;

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

    @Override public void clickMenuNavigation() {
        view.openNavigation(event.getAddress());
    }

    @Override public boolean canOpenNavigation() {
        return !event.getAddress().isEmpty();
    }

    @Override public void clickMenuShare() {
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

        if (isNullOrEmpty(event.getAddress()) || isNullOrEmpty(event.getPlaceName())) {
            view.showEventLocation(event.getPlaceNameOrAddress());
        } else {
            view.showEventLocation(event.getPlaceName(), event.getAddress());
        }

        view.showEventDescription(event.getDescription());
        view.showEventTime(startsAt, endsAt);
    }
}
