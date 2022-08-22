package com.crawling.item.controller;

import com.crawling.item.dto.MemberDto;
import com.crawling.item.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public void createMember(@RequestBody MemberDto memberDto) {

        memberService.createMember(memberDto);

    }
}
