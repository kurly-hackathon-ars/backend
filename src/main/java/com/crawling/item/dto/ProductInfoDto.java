package com.crawling.item.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class ProductInfoDto {
    private Long id;                    //상품 id
    private String imgUrl;              //이미지 url
    private String prodName;            //상품명
    private String originPrice;         //상품 원가
    private String salePrice;           //상품 할인가
    private String category;            //상품 카테고리
    private LocalDateTime insertDate;   //입고 일자
    private int count;                  //재고 수
    private boolean soldOut;            //재고 여부
}
