package com.app.weatherapp.api.model;

import com.app.weatherapp.api.converter.LongToLocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

public class WeatherData {


    private Long id;
    private String base;
    private String name;
    private Integer cod;

    @JsonDeserialize(converter = LongToLocalDateTimeConverter.class)
    private LocalDateTime dt;
    private String dt_txt;
    private Integer visibility;

    private Coordinate coord;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Cloud clouds;
    private System sys;


    public static class Weather {
        private Long id;
        private String main;
        private String description;
        private String icon;

        public Weather() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class Coordinate {
        private Double lon;
        private Double lat;

        public Coordinate() {
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }
    }

    public static class Main {
        private Double temp;
        private Double pressure;
        private Double humidity;
        private Double tempMin;
        private Double tempMax;

        public Main() {
        }

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public Double getTempMin() {
            return tempMin;
        }

        @JsonSetter(value = "temp_min")
        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTempMax() {
            return tempMax;
        }

        @JsonSetter(value = "temp_max")
        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }


    }

    public static class System {
        private Integer type;
        private Long id;
        private Double message;
        private String country;

        @JsonDeserialize(converter = LongToLocalDateTimeConverter.class)
        private LocalDateTime sunset;

        @JsonDeserialize(converter = LongToLocalDateTimeConverter.class)
        private LocalDateTime sunrise;

        public System() {
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getMessage() {
            return message;
        }

        public void setMessage(Double message) {
            this.message = message;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public LocalDateTime getSunset() {
            return sunset;
        }

        public void setSunset(LocalDateTime sunset) {
            this.sunset = sunset;
        }

        public LocalDateTime getSunrise() {
            return sunrise;
        }

        public void setSunrise(LocalDateTime sunrise) {
            this.sunrise = sunrise;
        }
    }

    public static class Wind {
        private Double speed;
        private Integer deg;

        public Wind() {
        }

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public Integer getDeg() {
            return deg;
        }

        public void setDeg(Integer deg) {
            this.deg = deg;
        }
    }

    public static class Cloud {
        private String all;

        public Cloud() {
        }

        public Cloud(String all) {
            this.all = all;
        }

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }
    }

    public WeatherData() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public System getSys() {
        return sys;
    }

    public void setSys(System sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
