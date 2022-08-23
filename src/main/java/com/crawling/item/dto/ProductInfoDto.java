package com.crawling.item.dto;

import com.crawling.item.entity.Product;
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
    private Integer originPrice;         //상품 원가
    private Integer salePrice;           //상품 할인가
    private String category;            //상품 카테고리

    public Product toProductEntity() {
        return Product.builder()
                .no(id)
                .imgUrl(imgUrl)
                .name(prodName)
                .originPrice(originPrice != null ? originPrice : null)
                .salePrice(salePrice != null ? salePrice : null)
                .category(category)
                .build();
    }
}
