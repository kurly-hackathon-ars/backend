package com.crawling.item.controller;

import com.crawling.item.dto.MemberDto;
import com.crawling.item.exception.MemberCreateErrorException;
import com.crawling.item.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<Boolean> createMember(@RequestBody MemberDto memberDto) {

        try {
            memberService.createMember(memberDto);

            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new MemberCreateErrorException(ex);
        }

    }
}
