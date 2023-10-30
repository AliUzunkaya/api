package com.example.Weather.controller;

import com.example.Weather.service.WeatherService;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherControllerTest {

    @InjectMocks
    private WeatherController weatherController;  // WeatherController sınıfını doğrudan test ediyoruz

    @Mock
    private WeatherService weatherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeather() throws JSONException {
        // Mock servis verisi
        String mockWeatherData = "Sunny";

        // Servis çağrısını sahte veri ile simulasyon yap
        when(weatherService.getWeather("CityName")).thenReturn(mockWeatherData);

        // Controller metodu çağır ve cevabı al
        ResponseEntity<String> response = weatherController.getWeather("CityName");

        // Beklenen veri ile gerçek veriyi karşılaştır
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockWeatherData, response.getBody());
    }
}


