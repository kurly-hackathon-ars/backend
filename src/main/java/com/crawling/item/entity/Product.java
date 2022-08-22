package com.crawling.item.entity;


import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long no;

    private String imgUrl;

    private String name;

    @Nullable
    private Integer originPrice;

    @Nullable
    private Integer salePrice;

    private String category;

}
