package br.com.semanalixozero.app.event;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import br.com.semanalixozero.app.R;
import butterknife.BindView;

import static android.view.LayoutInflater.from;
import static butterknife.ButterKnife.bind;

/**
 * @author Filipe Bezerra
 */
class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private Context context;
    private final List<Event> events;

    EventAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = from(context).inflate(R.layout.list_item_event, parent, false);
        return new ViewHolder(itemView);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = events.get(position);
        holder.textViewTitle.setText(event.getTitle());
        holder.textViewPlaceName.setText(event.getPlaceName());

        Long startsAt = event.getStartsAt();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH'h'mm", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(startsAt);
        String format = dateFormat.format(calendar.getTime());
        holder.textViewStartsAt.setText(context.getString(R.string.event_starts_at, format));
    }

    @Override public int getItemCount() {
        return events.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_title) TextView textViewTitle;
        @BindView(R.id.text_view_place_name) TextView textViewPlaceName;
        @BindView(R.id.text_view_starts_at) TextView textViewStartsAt;

        ViewHolder(View itemView) {
            super(itemView);
            bind(this, itemView);
        }
    }
}
