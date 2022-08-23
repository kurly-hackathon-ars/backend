package com.crawling.item.controller;

import com.crawling.item.dto.ActionDto;
import com.crawling.item.dto.ProductInfoDto;
import com.crawling.item.service.DummyService;
import com.crawling.item.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final DummyService dummyService;

    @GetMapping("/recommends/{itemId}")
    public List<ProductInfoDto> getRecommendItems(@PathVariable Long itemId) {
        return productService.getRecommendedProducts(itemId);
    }

    //todo : db 저장 & kafka에 produce
    @PostMapping("/actions")
    public ResponseEntity<Boolean> saveActions(@RequestBody ActionDto actionDto) {

        try {
            dummyService.saveDummyDataInKafkaAndDatabase(actionDto);

            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

    }


}
