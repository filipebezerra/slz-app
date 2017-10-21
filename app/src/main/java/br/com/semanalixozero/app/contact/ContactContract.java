package br.com.semanalixozero.app.contact;

/**
 * @author Filipe Bezerra
 */
interface ContactContract {

    interface View {

        void openWhatsApp(String contactNumber);
    }

    interface Presenter {

        void contactCeoViaWhatsApp();

        void contactCcoViaWhatsApp();
    }
}
