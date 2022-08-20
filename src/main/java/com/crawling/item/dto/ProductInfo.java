package com.crawling.item.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ProductInfo {
    private String imgUrl;
    private String prodName;
    private String originPrice;
    private String salePrice;
}
