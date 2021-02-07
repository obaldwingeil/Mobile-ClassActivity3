package com.example.classactivty3;

public class Weather {
    private String dateTime;
    private String description;
    private String feelsLike;

    public Weather(String dateTime, String description, String feelsLike){
        this.dateTime = dateTime;
        this.description = description;
        this.feelsLike = feelsLike;
    }


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }
}
