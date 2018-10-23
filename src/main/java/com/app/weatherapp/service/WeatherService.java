package com.app.weatherapp.service;

import com.app.weatherapp.model.entity.Weather;
import com.app.weatherapp.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class WeatherService {

    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    @Transactional
    public Weather save(Weather weather){
        return weatherRepository.save(weather);
    }


}
