package com.crawling.item.dto;

import com.crawling.item.dto.enums.ActionType;
import com.crawling.item.entity.ActivityLogs;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ActionDto {

    private Long id;

    @JsonProperty("member_id")
    private String memberId;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("action_type")
    private ActionType actionType;

    @JsonProperty("create_date")
    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return  "id=" + id +
                ", memberId=" + memberId +
                ", productId=" + productId +
                ", actionType=" + actionType +
                ", createdDate=" + createdDate;
    }

    public ActivityLogs toActivityLogsEntity() {
        return ActivityLogs.builder()
                .memberId(memberId)
                .productId(productId)
                .type(actionType)
                .build();
    }
}
