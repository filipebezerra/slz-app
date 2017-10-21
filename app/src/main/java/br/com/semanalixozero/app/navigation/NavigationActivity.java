package br.com.semanalixozero.app.navigation;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;

import com.devspark.robototextview.style.RobotoTypefaceSpan;

import java.util.ArrayList;
import java.util.List;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseActivity;
import br.com.semanalixozero.app.info.InfoFragment;
import br.com.semanalixozero.app.schedule.ScheduleFragment;
import br.com.semanalixozero.app.view.FragmentAdapter;
import butterknife.BindView;
import devlight.io.library.ntb.NavigationTabBar;

import static android.support.graphics.drawable.VectorDrawableCompat.create;
import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
import static br.com.semanalixozero.app.view.FragmentAdapter.createAdapter;
import static com.devspark.robototextview.RobotoTypefaces.TYPEFACE_ROBOTO_LIGHT;
import static com.devspark.robototextview.RobotoTypefaces.obtainTypeface;

/**
 * @author Filipe Bezerra
 */
public class NavigationActivity extends BaseActivity {

    @BindView(R.id.navigation_tab_bar) NavigationTabBar navigationTabBar;
    @BindView(R.id.view_pager) ViewPager viewPager;

    @Override protected int viewLayoutResource() {
        return R.layout.activity_navigation;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupTitle();
        setupViewPager();
        setupNavigationTabBar();
    }

    private void setupTitle() {
        RobotoTypefaceSpan span = new RobotoTypefaceSpan(this, TYPEFACE_ROBOTO_LIGHT);
        Spannable title = new SpannableString(getString(R.string.title_activity_navigation));
        title.setSpan(span, 0, title.length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setTitle(title);
    }

    private void setupViewPager() {
        FragmentAdapter fragmentAdapter = createAdapter(getSupportFragmentManager())
                //.add(new Fragment())
                .add(ScheduleFragment.create())
                //.add(new Fragment())
                .add(InfoFragment.create());
        viewPager.setAdapter(fragmentAdapter);
    }

    private void setupNavigationTabBar() {
        List<NavigationTabBar.Model> models = new ArrayList<>();
        /*
        models.add(
                new NavigationTabBar.Model.Builder(
                        create(getResources(), R.drawable.ic_person_pin_black_24dp, getTheme()),
                        ContextCompat.getColor(this, android.R.color.transparent))
                        .title(getString(R.string.title_tab_my_schedule))
                        .build());
        */
        models.add(
                new NavigationTabBar.Model.Builder(
                        create(getResources(), R.drawable.ic_schedule_black_24dp, getTheme()),
                        ContextCompat.getColor(this, android.R.color.transparent))
                        .title(getString(R.string.title_tab_schedule))
                        .build());
        /*
        models.add(
                new NavigationTabBar.Model.Builder(
                        create(getResources(), R.drawable.ic_rss_feed_black_24dp, getTheme()),
                        ContextCompat.getColor(this, android.R.color.transparent))
                        .title(getString(R.string.title_tab_feed))
                        .build());
        */
        models.add(
                new NavigationTabBar.Model.Builder(
                        create(getResources(), R.drawable.ic_info_outline_black_24dp, getTheme()),
                        ContextCompat.getColor(this, android.R.color.transparent))
                        .title(getString(R.string.title_tab_info))
                        .build());

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager);
        navigationTabBar.setTypeface(obtainTypeface(this, TYPEFACE_ROBOTO_LIGHT));
    }
}
