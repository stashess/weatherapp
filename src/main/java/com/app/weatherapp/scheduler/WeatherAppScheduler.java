package com.app.weatherapp.scheduler;

import com.app.weatherapp.api.WeatherApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class WeatherAppScheduler {

    @Autowired
    private WeatherApiClient weatherApiClient;

    @Scheduled(fixedDelay = 3600000,initialDelay = 1000)
    public void updateWeatherTask(){
        weatherApiClient.getCurrentWeatherData();
        //todo action
    }
}
