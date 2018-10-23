package com.app.weatherapp.repository;

import com.app.weatherapp.model.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherRepository {

    @Autowired
    private WeatherDataJpaRepository weatherDataJpaRepository;

    public Weather save(Weather weather){
        return weatherDataJpaRepository.save(weather);
    }

}
