package br.com.semanalixozero.app.aboutus;

/**
 * @author Filipe Bezerra
 */
interface AboutUsContract {

    interface View {

        void openSite(String uriString);
    }

    interface Presenter {

        void clickButtonVisitIlzbSite();

        void clickButtonVisitSrzSite();
    }
}
