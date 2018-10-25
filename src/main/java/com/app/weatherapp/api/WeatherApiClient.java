package com.app.weatherapp.api;


import com.app.weatherapp.api.model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@Component
public class WeatherApiClient {

    @Value("${weatherApi.url}")
    private String weatherServiceUrl;

    @Value("${weatherApi.current}")
    private String currentWeather;

    @Value("${weatherApi.forecast}")
    private String weatherForecast;

    @Value("${weatherApi.id}")
    private String cityId;

    @Value("${weatherApi.appid}")
    private String appId;

    private RestTemplate restTemplate;

    @Autowired
    public WeatherApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<WeatherData> getCurrentWeatherDataResponseEntity(){

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(weatherServiceUrl + currentWeather)
                .queryParam("id",cityId)
                .queryParam("appId",appId);

        return restTemplate.getForEntity(builder.build().toString(), WeatherData.class);
    }

    public WeatherData getCurrentWeatherData(){
        return getCurrentWeatherDataResponseEntity().getBody();
    }

}
