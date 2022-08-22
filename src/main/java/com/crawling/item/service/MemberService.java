package com.crawling.item.service;

import com.crawling.item.dto.MemberDto;
import com.crawling.item.entity.Member;
import com.crawling.item.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberDto memberDto) {

        Member member = memberDto.toMemberEntity();

        memberRepository.save(member);

    }

}
