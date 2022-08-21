package com.crawling.item.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class FavoriteDto {

    private Long id;
    private Long userId;
    private Long productId;
    private LocalDateTime createdDate;

}
