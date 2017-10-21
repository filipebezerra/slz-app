package br.com.semanalixozero.app.eventdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseActivity;
import br.com.semanalixozero.app.event.Event;
import br.com.semanalixozero.app.util.HtmlUtils;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Filipe Bezerra
 */
public class EventDetailActivity extends BaseActivity implements EventDetailContract.View {

    public static final String EXTRA_EVENT = "event";

    private EventDetailContract.Presenter presenter;

    @BindView(R.id.text_view_title) TextView textViewEventTitle;
    @BindView(R.id.text_view_time) TextView textViewEventTime;
    @BindView(R.id.text_view_description) TextView textViewEventDescription;

    @Override protected int viewLayoutResource() {
        return R.layout.activity_event_detail;
    }

    @Override protected void onCreate(@Nullable Bundle inState) {
        super.onCreate(inState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final Event event = getIntent().getParcelableExtra(EXTRA_EVENT);
        presenter = new EventDetailPresenter(this, event);
    }

    @Override public void showEventTitle(String title) {
        textViewEventTitle.setText(title);
    }

    @Override public void showEventDescription(String description) {
        HtmlUtils.renderHtml(description, textViewEventDescription);
    }

    @Override public void showEventTime(String startsAt, String endsAt) {
        textViewEventTime.setText(getString(R.string.event_time, startsAt, endsAt));
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_event_detail, menu);
        return true;
    }

    @Override public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_map).setVisible(presenter.canOpenMap());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_map:
                presenter.clickMenuShowLocation();
                return true;
            case R.id.action_share:
                presenter.clickMenuShareEvent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override public void openMap(String address) {
        Uri uri = Uri.parse("geo:0,0?q=".concat(address.replace(" ", "%20")));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override public void shareContent(String content) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, content);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.share_with)));
    }

    @OnClick(R.id.fab) void onClickFab() {
        presenter.clickFab();
    }

    @Override public void openSite(String uriString) {
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                .setToolbarColor(ContextCompat.getColor(this, R.color.primary))
                .setShowTitle(true)
                .build();
        customTabsIntent.launchUrl(this, Uri.parse(uriString));
    }
}
