package com.crawling.item.dto;

import com.crawling.item.entity.Member;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class MemberDto {

    private Long id;

    @JsonProperty("member_id")
    private String memberId;

    private String name;
    private String grade;

    public Member toMemberEntity() {
        return Member.builder()
                .memberId(memberId)
                .name(name)
                .grade(grade)
                .build();
    }
}
