package br.com.semanalixozero.app.cities;

/**
 * @author Filipe Bezerra
 */
interface CitiesContract {

    interface View {

        void openWebSite(String uriString);
    }

    interface Presenter {

        void openCitySite(int position);
    }
}
