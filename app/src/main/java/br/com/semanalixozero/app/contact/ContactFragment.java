package br.com.semanalixozero.app.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;
import butterknife.OnClick;

/**
 * @author Filipe Bezerra
 */
public class ContactFragment extends BaseFragment implements ContactContract.View {

    public static ContactFragment create() {
        return new ContactFragment();
    }

    private ContactContract.Presenter presenter;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_contact;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ContactPresenter(this);
    }

    @OnClick(R.id.button_contact_ceo) void onClickButtonContactCeo() {
        presenter.contactCeoViaWhatsApp();
    }

    @OnClick(R.id.button_contact_cco) void onClickButtonContactCco() {
        presenter.contactCcoViaWhatsApp();
    }

    @Override public void openWhatsApp(String contactNumber) {
        Uri uri = Uri.parse("http://api.whatsapp.com/send?1=pt_BR")
                .buildUpon()
                .appendQueryParameter("phone", contactNumber)
                .build();
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
