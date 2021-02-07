package com.example.classactivty3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder>{

    private List<Weather> weather;

    public WeatherAdapter(List<Weather> weather){
        this.weather = weather;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View weatherView = inflater.inflate(R.layout.item_weather, parent, false);
        ViewHolder viewHolder = new ViewHolder(weatherView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weather weather1 = weather.get(position);
        holder.textView_dateTime.setText(weather1.getDateTime());
        holder.textView_description.setText(weather1.getDescription());
        String feels = "Feels Like\n" + weather1.getFeelsLike();
        holder.textView_feelsLike.setText(feels);
    }

    @Override
    public int getItemCount() {
        return weather.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView_dateTime;
        TextView textView_description;
        TextView textView_feelsLike;

        public ViewHolder(View itemView){
            super(itemView);
            textView_dateTime = itemView.findViewById(R.id.textView_dateTime);
            textView_description = itemView.findViewById(R.id.textView_description);
            textView_feelsLike = itemView.findViewById(R.id.textView_feelsLike);
        }
    }

}
