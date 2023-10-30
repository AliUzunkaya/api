package com.example.Weather.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "weather_date")
    private Date weatherDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Date getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(Date weatherDate) {
        this.weatherDate = weatherDate;
    }
}
