package com.bkbn.eventmanagement.service.impl;

import com.bkbn.eventmanagement.dto.OpenWeatherResponse;
import com.bkbn.eventmanagement.service.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientImpl implements RestClient {
    @Value("${open-weather.url}")
    private String openWeatherBaseUrl;
    private final RestTemplate client;

    public RestClientImpl(RestTemplateBuilder restTemplateBuilder) {
        client = restTemplateBuilder
                .build();
    }
    @Override
    public OpenWeatherResponse getWeatherData(String city) {
        return client.exchange(openWeatherBaseUrl + city, HttpMethod.GET, null, OpenWeatherResponse.class).getBody();
    }
}
