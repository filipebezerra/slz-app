package br.com.semanalixozero.app.aboutevent;

/**
 * @author Filipe Bezerra
 */
class AboutEventPresenter implements AboutEventContract.Presenter {

    private final AboutEventContract.View view;

    AboutEventPresenter(AboutEventContract.View view) {
        this.view = view;
    }

}
