package com.crawling.item.controller;

import com.crawling.item.dto.ActionDto;
import com.crawling.item.dto.ProductInfoDto;
import com.crawling.item.helper.RandomHelper;
import com.crawling.item.service.KafkaProducer;
import com.crawling.item.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    //todo : action받아줄 컨트롤러
    //    -> ml쪽 api에 요청해서 데이터 받아서 (item_id)
    //    -> products 테이블 > imgUrl, 가격정보 > front에 뿌려준다.

    private final ProductService productService;
    private final KafkaProducer kafkaProducer;

    @GetMapping("/recommends")
    public List<ProductInfoDto> getRecommendItems() {

        return productService.getRecommendedProducts();
    }

    //todo : db 저장 & kafka에 produce
    @PostMapping("/")
    public ActionDto test(@RequestBody ActionDto actionDto) {

        actionDto.setId(RandomHelper.randomLong());
        actionDto.setCreatedDate(LocalDateTime.now());

        System.out.println(actionDto.toString());

        return actionDto;
    }


}
