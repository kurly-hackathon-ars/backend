package com.crawling.item.service;

import com.crawling.item.dto.ProductInfoDto;
import com.crawling.item.entity.Product;
import com.crawling.item.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public List<ProductInfoDto> getRecommendedProducts(Long itemId) {

        String requestUrl = "http://3.37.151.144:8000/recommend_by_keyword/"+itemId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<List> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, List.class);

        List<Long> recommendedItemLists = responseEntity.getBody();

        List<Product> products = productRepository.findItemsInId(recommendedItemLists);

        return products.stream().map(product -> ProductInfoDto.builder()
                .id(product.getNo())
                .imgUrl(product.getImgUrl())
                .prodName(product.getName())
                .category(product.getCategory())
                .originPrice(product.getOriginPrice())
                .salePrice(product.getSalePrice())
                .build()).collect(Collectors.toList());
    }

}
