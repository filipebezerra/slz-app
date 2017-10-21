package br.com.semanalixozero.app.schedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.semanalixozero.app.R;
import br.com.semanalixozero.app.base.BaseFragment;
import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * @author Filipe Bezerra
 */
public class EventsFragment extends BaseFragment implements EventsContract.View {

    private static final String EXTRA_EVENTS = "events";

    public static EventsFragment create(List<Event> events) {
        EventsFragment eventsFragment = new EventsFragment();

        Bundle arguments = new Bundle();
        arguments.putParcelableArrayList(EXTRA_EVENTS, new ArrayList<>(events));
        eventsFragment.setArguments(arguments);

        return eventsFragment;
    }

    private EventsContract.Presenter presenter;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override protected int fragmentViewResource() {
        return R.layout.fragment_events;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Event> events = getArguments().getParcelableArrayList(EXTRA_EVENTS);
        presenter = new EventsPresenter(this, events);
    }

    @Override public void showEvents(List<Event> events) {
        EventAdapter eventAdapter = new EventAdapter(getContext(), events);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(eventAdapter);
        //recyclerView.addItemDecoration(new StickyRecyclerHeadersDecoration(eventAdapter));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
    }
}
