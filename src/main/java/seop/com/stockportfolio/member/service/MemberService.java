package seop.com.stockportfolio.member.service;

import seop.com.stockportfolio.member.domain.entity.Member;

import java.util.List;

public interface MemberService {

    String insert(Member member);
    String findOneById(String id);

}
