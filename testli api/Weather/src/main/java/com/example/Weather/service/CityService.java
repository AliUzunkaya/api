package com.example.Weather.service;

import com.example.Weather.entity.City;
import com.example.Weather.entity.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

}

