package br.com.semanalixozero.app.eventdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

import java.util.ArrayList;
import java.util.List;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseActivity;
import br.com.semanalixozero.app.event.Event;
import br.com.semanalixozero.app.util.HtmlUtils;
import br.com.semanalixozero.app.util.ViewUtils;
import butterknife.BindView;
import butterknife.OnClick;

import static br.com.semanalixozero.app.util.FeedbackHelper.showLongPeriodFeedback;
import static com.getkeepsafe.taptargetview.TapTarget.forToolbarMenuItem;
import static com.getkeepsafe.taptargetview.TapTarget.forView;

/**
 * @author Filipe Bezerra
 */
public class EventDetailActivity extends BaseActivity implements EventDetailContract.View {

    public static final String EXTRA_EVENT = "event";

    private EventDetailContract.Presenter presenter;

    @BindView(R.id.text_view_title) TextView textViewEventTitle;
    @BindView(R.id.text_view_place_name) TextView textViewPlaceName;
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

    @Override public void showEventLocation(String placeName) {
        textViewPlaceName.setText(getString(R.string.event_place_name, placeName));
    }

    @Override public void showEventLocation(String placeName, String address) {
        textViewPlaceName.setText(getString(R.string.event_place_location, placeName, address));
    }

    @Override public void showEventTime(String startsAt, String endsAt) {
        textViewEventTime.setText(getString(R.string.event_time, startsAt, endsAt));
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_event_detail, menu);
        return true;
    }

    @Override public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_navigation).setVisible(presenter.canOpenNavigation());
        presenter.checkCanDisplayEventDetailsDiscovery();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_navigation:
                presenter.clickMenuNavigation();
                return true;
            case R.id.action_share:
                presenter.clickMenuShare();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override public void openNavigation(String address) {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=".concat(address.replace(" ", "%20")));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    @Override public void shareContent(String content) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, content);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.share_with)));
    }

    @Override public void displayEventDetailsDiscovery() {
        initializeDiscovery();
    }

    @Override public void displayEventDetailsDiscoveryExplanation() {
        showLongPeriodFeedback(getCoordinatorLayout(), R.string.message_discovery_explanation);
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

    private void initializeDiscovery() {
        final Toolbar toolbar = findViewById(R.id.toolbar);

        final ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView != null) {
            ViewUtils.onLaidOut(actionMenuView, () -> {
                List<TapTarget> targets = new ArrayList<>();
                targets.add(createFabTapTarget());

                if (presenter.canOpenNavigation()) {
                    targets.add(createMapMenuItemTapTarget(toolbar));
                }

                targets.add(createShareMenuItemTapTarget(toolbar));

                displayDiscovery(targets);
            });
        }
    }

    private ActionMenuView getActionMenuView(Toolbar toolbar) {
        View toolbarChild;
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            toolbarChild = toolbar.getChildAt(i);

            if (toolbarChild instanceof ActionMenuView) {
                return (ActionMenuView) toolbarChild;
            }
        }

        return null;
    }

    private TapTarget createFabTapTarget() {
        return forView(findViewById(R.id.fab),
                getString(R.string.title_event_link_discovery),
                getString(R.string.description_event_link_discovery)).transparentTarget(true);
    }

    private TapTarget createMapMenuItemTapTarget(Toolbar toolbar) {
        return createMenuItemTapTarget(toolbar, R.id.action_navigation,
                R.string.title_navigation_to_event_discovery, R.string.description_navigation_to_event_discovery);
    }

    private TapTarget createShareMenuItemTapTarget(Toolbar toolbar) {
        return createMenuItemTapTarget(toolbar, R.id.action_share,
                R.string.title_share_event_discovery, R.string.description_share_event_discovery);
    }

    private TapTarget createMenuItemTapTarget(
            Toolbar toolbar, @IdRes int id, @StringRes int title, @StringRes int description) {
        return forToolbarMenuItem(toolbar,
                id, getString(title), getString(description)).transparentTarget(true);
    }

    private void displayDiscovery(List<TapTarget> targets) {
        new TapTargetSequence(this)
                .targets(targets)
                .listener(new TapTargetSequence.Listener() {
                    @Override public void onSequenceFinish() {
                        presenter.clickUserDiscoveredEventDetails();
                    }

                    @Override
                    public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {}

                    @Override public void onSequenceCanceled(TapTarget lastTarget) {
                        presenter.clickUserCancelledEventDetailsDiscovery();
                    }
                })
                .start();
    }
}
