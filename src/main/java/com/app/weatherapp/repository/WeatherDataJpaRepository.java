package com.app.weatherapp.repository;

import com.app.weatherapp.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataJpaRepository extends JpaRepository<Weather,Long> {

    @Override
    Weather save(Weather weather);

}
