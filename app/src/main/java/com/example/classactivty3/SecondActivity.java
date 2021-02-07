package com.example.classactivty3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<Weather> weather;
    private RecyclerView recyclerView;
    private TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recyclerView_weather);
        weather = new ArrayList<>();
        title = findViewById(R.id.textView_cityName);

        Intent intent = getIntent();
        Log.d("intent", intent.getStringExtra("data"));

        try {
            JSONObject data = new JSONObject(intent.getStringExtra("data"));
            String cityCountry = data.getJSONObject("city").getString("name") + ", " +
                    data.getJSONObject("city").getString("country");
            title.setText(cityCountry);

            JSONArray weatherArray = data.getJSONArray("list");
            for(int i = 0; i < weatherArray.length(); i++){
                JSONObject weatherJSON = weatherArray.getJSONObject(i);
                Weather weather1 = new Weather(
                        weatherJSON.getString("dt_txt"),
                        weatherJSON.getJSONArray("weather").getJSONObject(0).getString("description"),
                        weatherJSON.getJSONObject("main").getString("feels_like"));
                weather.add(weather1);
            }
            WeatherAdapter adapter = new WeatherAdapter(weather);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
