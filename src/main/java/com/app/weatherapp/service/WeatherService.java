package com.app.weatherapp.service;

import com.app.weatherapp.model.entity.Weather;
import com.app.weatherapp.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class WeatherService {

    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
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
        return weatherRepository.getWeathersByDate(startDate, endDate);
    }

    @Transactional
    public Weather deleteAndSave(Weather weather){
        weatherRepository.deleteByDate(weather.getDate());
        return weatherRepository.save(weather);
    }

}
