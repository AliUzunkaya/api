package com.example.Weather.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class WeatherService {

    public String getWeather(String city) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "0cb2da01df89710c70d599a94e7d3e35";
        String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?&appid=" + apiKey + "&units=metric&lang=tr";
        String response = restTemplate.getForObject(apiUrl + "&q=" + city, String.class);
        return processWeatherData(response);
    }

    String processWeatherData(String jsonResponse) throws JSONException {
        StringBuilder weatherData = new StringBuilder();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray weatherList = jsonObject.getJSONArray("list");

        // Bugünden itibaren 5 gün için veri al
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        int dayCounter = 0;

        for (int i = 0; i < weatherList.length(); i++) {
            JSONObject weatherInfo = weatherList.getJSONObject(i);
            long timestamp = weatherInfo.getLong("dt") * 1000;
            Date date = new Date(timestamp);

            // Sadece bugünden itibaren 5 gün boyunca olan verileri işle
            if (date.after(calendar.getTime()) && dayCounter < 5) {
                String formattedDate = dateFormat.format(date);
                JSONObject mainInfo = weatherInfo.getJSONObject("main");
                double temperature = mainInfo.getDouble("temp");
                JSONArray weatherArray = weatherInfo.getJSONArray("weather");
                String description = weatherArray.getJSONObject(0).getString("description");

                String data = formattedDate + ": " + temperature + "°C, " + description;
                weatherData.append(data).append("\n");

                // Veri eklediğimizde, bir sonraki gün için tarihi artır
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                dayCounter++;
            }
        }

        return weatherData.toString();
    }

}