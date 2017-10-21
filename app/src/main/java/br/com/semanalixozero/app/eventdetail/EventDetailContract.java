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

        void showEventTime(String startsAt, String endsAt);

        void shareContent(String content);
    }

    interface Presenter {

        void clickFab();

        void clickMenuShowLocation();

        boolean canOpenMap();

        void clickMenuShareEvent();
    }
}