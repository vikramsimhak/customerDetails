package com.api.customerdetails.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String callExternalApi() {
        return restTemplate.getForObject("https://www.google.com", String.class);
    }
}