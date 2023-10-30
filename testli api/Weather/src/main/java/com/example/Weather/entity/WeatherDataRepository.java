package com.example.Weather.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    List<WeatherData> findByCityOrderByDateAsc(String city);
}

