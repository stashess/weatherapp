package com.app.weatherapp.repository;

import com.app.weatherapp.model.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class WeatherRepository {

    private WeatherDataJpaRepository weatherDataJpaRepository;

    @Autowired
    public WeatherRepository(WeatherDataJpaRepository weatherDataJpaRepository) {
        this.weatherDataJpaRepository = weatherDataJpaRepository;
    }

    public void deleteByDate(LocalDateTime dateTime){
        weatherDataJpaRepository.deleteByDate(dateTime);
    }

    public Weather save(Weather weather){
        return weatherDataJpaRepository.save(weather);
    }

    public List<Weather> saveAll(List<Weather> weathers){
        return weatherDataJpaRepository.saveAll(weathers);
    }

    public List<Weather> getWeathersByDate(LocalDateTime startDate, LocalDateTime endDate){
        return weatherDataJpaRepository.findBetweenDates(startDate, endDate);
    }

    public Optional<Weather> getByDate(LocalDateTime localDateTime){
       return weatherDataJpaRepository.getByDate(localDateTime);
    }

}
