package br.com.semanalixozero.app.aboutus;

/**
 * @author Filipe Bezerra
 */
interface AboutUsContract {

    interface View {

        void openWebSite(String uriString);
    }

    interface Presenter {

        void openIlzbSite();

        void openSrzSite();
    }
}
