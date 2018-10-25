package com.app.weatherapp.model.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather",uniqueConstraints = {@UniqueConstraint(columnNames = "date",name = "unique_date")})
public class Weather {
    @Id
    @SequenceGenerator(name = "weather_seq", sequenceName = "weather_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_seq")
    private Long id;

    @Column(name = "date",nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @Column(name = "temp",nullable = false)
    private Double temp;

    public Weather() {
    }

    public Weather(LocalDateTime date, Double temp) {
        this.date = date;
        this.temp = temp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
