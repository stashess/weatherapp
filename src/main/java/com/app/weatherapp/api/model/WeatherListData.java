package com.app.weatherapp.api.model;

import java.util.List;

public class WeatherListData {
    private String cod;
    private Double message;
    private Integer cnt;
    private WeatherData[] list;

    public WeatherListData() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public WeatherData[] getList() {
        return list;
    }

    public void setList(WeatherData[] list) {
        this.list = list;
    }
}
