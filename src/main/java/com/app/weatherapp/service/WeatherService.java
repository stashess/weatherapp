package com.app.weatherapp.service;

import com.app.weatherapp.api.WeatherApiClient;
import com.app.weatherapp.model.entity.Weather;
import com.app.weatherapp.model.util.WeatherUtil;
import com.app.weatherapp.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class WeatherService {

    private WeatherRepository weatherRepository;

    private WeatherApiClient weatherApiClient;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, WeatherApiClient weatherApiClient) {
        this.weatherRepository = weatherRepository;
        this.weatherApiClient = weatherApiClient;
    }

    @Transactional
    public List<Weather> saveAll(List<Weather> weathers){
        return weatherRepository.saveAll(weathers);
    }

    @Transactional
    public Weather save(Weather weather){
        return weatherRepository.save(weather);
    }

    public List<Weather> getWeathersBetweenDates(LocalDateTime startDate,LocalDateTime endDate){
        if (endDate.isAfter(LocalDateTime.now())){
            WeatherUtil.getWeathers(weatherApiClient.getWeatherForecast().getList())
                    .forEach(this::updateOrSave);
        }
        return weatherRepository.getWeathersByDate(startDate, endDate);
    }

    @Transactional
    public Weather updateOrSave(Weather weather){
        Optional<Weather> dbEntity = weatherRepository.getByDate(weather.getDate());
        dbEntity.ifPresent(w -> weather.setId(w.getId()));
        return weatherRepository.save(weather);
    }

}
