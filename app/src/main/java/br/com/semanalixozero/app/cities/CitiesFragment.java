package br.com.semanalixozero.app.cities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;
import br.com.semanalixozero.app.recyclerview.ItemTouchListenerImpl;
import br.com.semanalixozero.app.recyclerview.OnItemTouchListener;
import butterknife.BindArray;
import butterknife.BindView;

import static android.support.v4.content.ContextCompat.getColor;
import static java.util.Arrays.asList;

/**
 * @author Filipe Bezerra
 */
public class CitiesFragment extends BaseFragment implements CitiesContract.View {

    public static CitiesFragment create() {
        return new CitiesFragment();
    }

    private CitiesContract.Presenter presenter;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindArray(R.array.city_names) String[] cityNames;
    @BindArray(R.array.city_paths) String[] cityPaths;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_cities;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new CitiesPresenter(this, cityPaths);

        CityAdapter cityAdapter = new CityAdapter(getContext(), asList(cityNames));

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(cityAdapter);
        recyclerView.addOnItemTouchListener(
                new ItemTouchListenerImpl(getContext(), recyclerView,
                        new OnItemTouchListener() {
            @Override public void onSingleTapUp(View view, int position) {
                presenter.openCitySite(position);
            }

            @Override public void onLongPress(View view, int position) {}
        }));
    }

    @Override public void openWebSite(String uriString) {
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                .setToolbarColor(getColor(getContext(), R.color.primary))
                .setShowTitle(true)
                .build();
        customTabsIntent.launchUrl(getContext(), Uri.parse(uriString));
    }
}
