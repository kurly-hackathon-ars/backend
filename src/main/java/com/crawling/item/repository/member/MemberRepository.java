package com.crawling.item.repository.member;

import com.crawling.item.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public int countMemberByMemberId(String memberId);

}
