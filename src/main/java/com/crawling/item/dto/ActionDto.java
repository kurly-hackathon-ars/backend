package com.crawling.item.dto;

import com.crawling.item.dto.enums.ActionType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class ActionDto {

    private Long id;
    private Long userId;
    private Long productId;
    private ActionType actionType;
    private LocalDateTime createdDate;

}
