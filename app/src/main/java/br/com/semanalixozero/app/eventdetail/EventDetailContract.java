package br.com.semanalixozero.app.eventdetail;

/**
 * @author Filipe Bezerra
 */
interface EventDetailContract {

    interface View {

        void showEventTitle(String title);

        void openSite(String uriString);

        void openMap(String address);

        void showEventDescription(String description);

        void showEventPlaceName(String placeName);

        void showEventTime(String startsAt, String endsAt);

        void shareContent(String content);

        void displayEventDetailsDiscovery();

        void displayEventDetailsDiscoveryExplanation();
    }

    interface Presenter {

        void clickFab();

        void clickMenuShowLocation();

        boolean canOpenMap();

        void clickMenuShareEvent();

        void checkCanDisplayEventDetailsDiscovery();

        void clickUserDiscoveredEventDetails();

        void clickUserCancelledEventDetailsDiscovery();
    }
}
