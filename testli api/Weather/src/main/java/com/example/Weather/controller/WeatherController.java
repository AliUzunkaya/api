package com.example.Weather.controller;

import com.example.Weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    // GET isteği için /weather endpoint'i
    @GetMapping("/weather")
    public ResponseEntity<String> getWeather(@RequestParam String city) throws JSONException {
        // Verilen şehre ait hava durumu verilerini getir
        String weatherData = weatherService.getWeather(city);
        // Hava durumu verilerini JSON formatında yanıt olarak döndür
        return ResponseEntity.ok(weatherData);
    }

    // POST isteği için /weather endpoint'i
    @PostMapping("/weather")
    public ResponseEntity<String> createWeather(@RequestParam String city) throws JSONException {
        // Verilen şehre ait yeni hava durumu verileri oluştur veya işlemleri gerçekleştir
        String createdData = weatherService.getWeather(city);
        // Oluşturulan hava durumu verilerini JSON formatında yanıt olarak döndür
        return ResponseEntity.ok(createdData);
    }
}
