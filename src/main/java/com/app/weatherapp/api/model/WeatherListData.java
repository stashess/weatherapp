package com.app.weatherapp.api.model;

import java.util.List;

public class WeatherListData {
    private String cod;
    private Double message;
    private Integer cnt;
    private List<WeatherData> dataList;

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

    public List<WeatherData> getDataList() {
        return dataList;
    }

    public void setDataList(List<WeatherData> dataList) {
        this.dataList = dataList;
    }
}
