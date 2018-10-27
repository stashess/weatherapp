package com.app.weatherapp.repository;

import com.app.weatherapp.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface WeatherDataJpaRepository extends JpaRepository<Weather,Long> {

    @Override
    @Modifying
    Weather save(Weather weather);

    @Query(value = "DELETE FROM Weather where date = :date")
    @Modifying
    void deleteByDate(@Param("date") LocalDateTime date);

    @Override
    <S extends Weather> List<S> saveAll(Iterable<S> iterable);

    @Query(value = "SELECT w FROM Weather w where w.date >= :startDate and w.date <= :endDate")
    List<Weather> findBetweenDates(@Param("startDate") LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);

    Optional<Weather> getByDate(LocalDateTime localDateTime);
}
