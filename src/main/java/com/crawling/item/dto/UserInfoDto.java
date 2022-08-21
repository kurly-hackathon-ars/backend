package com.crawling.item.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class UserInfoDto {

    private Long id;
    private String memberId;
    private String name;
    private String grade;
    private LocalDateTime createdAt;

}
