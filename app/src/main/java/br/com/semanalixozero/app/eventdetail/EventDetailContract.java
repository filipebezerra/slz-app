package br.com.semanalixozero.app.eventdetail;

/**
 * @author Filipe Bezerra
 */
interface EventDetailContract {

    interface View {

        void showEventTitle(String title);

        void openSite(String uriString);

        void openNavigation(String address);

        void showEventDescription(String description);

        void showEventLocation(String placeName);

        void showEventLocation(String placeName, String address);

        void showEventTime(String startsAt, String endsAt);

        void shareContent(String content);

        void displayEventDetailsDiscovery();

        void displayEventDetailsDiscoveryExplanation();
    }

    interface Presenter {

        void clickFab();

        void clickMenuNavigation();

        boolean canOpenNavigation();

        void clickMenuShare();

        void checkCanDisplayEventDetailsDiscovery();

        void clickUserDiscoveredEventDetails();

        void clickUserCancelledEventDetailsDiscovery();
    }
}
