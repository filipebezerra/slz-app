package br.com.semanalixozero.app.cities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

import br.com.semanalixozero.app.R;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.LayoutInflater.from;
import static br.com.semanalixozero.app.util.ResourcesHelper.getPaletteColors;
import static com.amulyakhare.textdrawable.util.ColorGenerator.create;
import static java.lang.String.valueOf;

/**
 * @author Filipe Bezerra
 */
class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private final Context context;

    private final List<String> cityNames;

    private final ColorGenerator colorGenerator;

    CityAdapter(final Context context, final List<String> cityNames) {
        this.context = context;
        this.cityNames = cityNames;
        colorGenerator = create(getPaletteColors(context));
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = from(context).inflate(R.layout.list_item_city, parent, false);
        return new ViewHolder(itemView);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        final String cityName = cityNames.get(position);

        TextDrawable textDrawable = TextDrawable.builder()
                .buildRound(valueOf(cityName.charAt(0)), colorGenerator.getColor(cityName));

        holder.textViewCityName.setText(cityName);
        holder.imageViewLetter.setImageDrawable(textDrawable);
    }

    @Override public int getItemCount() {
        return cityNames.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_view_letter) ImageView imageViewLetter;
        @BindView(R.id.text_view_city_name) TextView textViewCityName;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
