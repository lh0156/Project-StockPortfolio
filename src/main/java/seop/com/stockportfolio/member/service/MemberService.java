package seop.com.stockportfolio.member.service;

import seop.com.stockportfolio.member.domain.entity.Member;

public interface MemberService {

    void save(Member member);
    Member findOneById(String id);

}
