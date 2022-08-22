package com.crawling.item.service;

import com.crawling.item.dto.MemberDto;
import com.crawling.item.entity.Member;
import com.crawling.item.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDto createMember(MemberDto memberDto) {

        Member member = memberDto.toMemberEntity();

        memberRepository.save(member);

        return MemberDto.builder()
                .id(member.getNo())
                .memberId(member.getMemberId())
                .name(member.getName())
                .grade(member.getGrade())
                .build();

    }

}
