package com.app.weatherapp.model.util;

import com.app.weatherapp.api.model.WeatherData;
import com.app.weatherapp.model.dto.WeatherDto;
import com.app.weatherapp.model.entity.Weather;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherUtil {

    public final static Double KELVIN_TO_CELSIUS = -273.15;

    public static List<WeatherDto> getWeatherDto(List<Weather> weathers) {
        return weathers.stream().map(weather -> new WeatherDto(weather.getTemp(), weather.getDate())).collect(Collectors.toList());
    }

    public static Optional<WeatherDto> getWeather (Weather weathera){
        return getWeatherDto(Collections.singletonList(weathera)).stream().findFirst();
    }

    public static List<Weather> getWeathers (List<WeatherData> weatherData){
        return weatherData.stream().map(w -> new Weather(w.getDt(),(w.getMain().getTemp() + KELVIN_TO_CELSIUS))).collect(Collectors.toList());
    }

    public static Optional<Weather> getWeather (WeatherData weatherData){
        return getWeathers(Collections.singletonList(weatherData)).stream().findFirst();
    }

}
