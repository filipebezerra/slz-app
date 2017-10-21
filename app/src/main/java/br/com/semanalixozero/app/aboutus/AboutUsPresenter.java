package br.com.semanalixozero.app.aboutus;

/**
 * @author Filipe Bezerra
 */
class AboutUsPresenter implements AboutUsContract.Presenter {

    private final AboutUsContract.View view;

    AboutUsPresenter(AboutUsContract.View view) {
        this.view = view;
    }

    @Override public void openIlzbSite() {
        view.openWebSite("http://ilzb.org/");
    }

    @Override public void openSrzSite() {
        view.openWebSite("http://residuozero.org.br/goias/");
    }
}
