package br.com.semanalixozero.app.cities;

/**
 * @author Filipe Bezerra
 */
class CitiesPresenter implements CitiesContract.Presenter {

    private final CitiesContract.View view;

    private String[] cityPaths;

    CitiesPresenter(CitiesContract.View view, String... cityPaths) {
        this.view = view;
        this.cityPaths = cityPaths;
    }

    @Override public void openCitySite(int position) {
        final String urlString = "http://semanalixozero.com.br/" + cityPaths[position];
        view.openWebSite(urlString);
    }
}
