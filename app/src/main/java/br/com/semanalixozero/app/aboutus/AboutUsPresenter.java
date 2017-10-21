package br.com.semanalixozero.app.aboutus;

/**
 * @author Filipe Bezerra
 */
class AboutUsPresenter implements AboutUsContract.Presenter {

    private final AboutUsContract.View view;

    AboutUsPresenter(AboutUsContract.View view) {
        this.view = view;
    }

    @Override public void clickButtonVisitIlzbSite() {
        view.openSite("http://ilzb.org/");
    }

    @Override public void clickButtonVisitSrzSite() {
        view.openSite("http://residuozero.org.br/goias/");
    }
}
