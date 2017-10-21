package br.com.semanalixozero.app.contact;

/**
 * @author Filipe Bezerra
 */
class ContactPresenter implements ContactContract.Presenter {

    private static final String CEO_CONTACT = "556298209899";

    private static final String CCO_CONTACT = "5562981607708";

    private final ContactContract.View view;

    ContactPresenter(ContactContract.View view) {
        this.view = view;
    }

    @Override public void contactCeoViaWhatsApp() {
        view.openWhatsApp(CEO_CONTACT);
    }

    @Override public void contactCcoViaWhatsApp() {
        view.openWhatsApp(CCO_CONTACT);
    }
}
