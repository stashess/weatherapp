package com.app.weatherapp.scheduler;

import com.app.weatherapp.api.WeatherApiClient;
import com.app.weatherapp.api.model.WeatherData;
import com.app.weatherapp.model.entity.Weather;
import com.app.weatherapp.model.util.WeatherUtil;
import com.app.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Optional;

public class WeatherAppScheduler {

    @Autowired
    private WeatherApiClient weatherApiClient;

    @Autowired
    private WeatherService weatherService;

    @Scheduled(fixedDelay = 360000, initialDelay = 1000)
    public void updateWeatherTask() {
        WeatherData currentWeatherData = weatherApiClient.getCurrentWeatherData();
        Optional<Weather> weather = WeatherUtil.getWeather(currentWeatherData);
        weather.ifPresent(w -> weatherService.updateOrSave(w));
    }
}
