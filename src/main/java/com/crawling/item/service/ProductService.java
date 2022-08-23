package com.crawling.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final RestTemplate restTemplate;

    public Object getRecommendedProducts() {

        String requestUrl = "https://8eoluopi8h.execute-api.ap-northeast-2.amazonaws.com/recommend_by_activity";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, Object.class);

        return responseEntity.getBody();
    }

}
