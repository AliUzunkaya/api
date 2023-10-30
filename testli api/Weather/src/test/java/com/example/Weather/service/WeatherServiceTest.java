package com.example.Weather.service;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherServiceTest {

    @Test
    public void testProcessWeatherData() throws JSONException {
        // Mock JSON verisi
        String mockJsonResponse = "{\"list\": [" +
                "{\"dt\": 1667648000, \"main\": {\"temp\": 25}, \"weather\": [{\"description\": \"Sunny\"}]}, " +
                "{\"dt\": 1667734400, \"main\": {\"temp\": 30}, \"weather\": [{\"description\": \"Clear\"}]}" +
                "]}";

        WeatherService weatherService = new WeatherService();
        String processedData = weatherService.processWeatherData(mockJsonResponse);

        // Beklenen sonuç (Tarih formatı: "dd MMMM")
        String expectedData = "08 March: 25.0°C, Sunny\n" +
                "09 March: 30.0°C, Clear\n";

        // Beklenen sonuçla gerçek sonuç karşılaştırılır
        assertEquals(expectedData, processedData, "Hava durumu verileri doğru şekilde işlenemedi.");
    }
}
