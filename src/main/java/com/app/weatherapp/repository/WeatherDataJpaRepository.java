package com.app.weatherapp.repository;

import com.app.weatherapp.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherDataJpaRepository extends JpaRepository<Weather,Long> {

    @Override
    Weather save(Weather weather);

    List<Weather> findByDateIsGreaterThanEqualAndDateIsLessThanEqual(LocalDateTime startDate, LocalDateTime endDate);

}
