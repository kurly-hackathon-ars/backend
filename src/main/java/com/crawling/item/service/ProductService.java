package com.crawling.item.service;

import com.crawling.item.dto.ProductInfoDto;
import com.crawling.item.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public List<ProductInfoDto> getRecommendedProducts() {

        String requestUrl = "http://3.37.151.144:8000/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<List> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, List.class);

        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();

    }

}
