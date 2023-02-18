package seop.com.stockportfolio.member.service.impl;

import lombok.RequiredArgsConstructor;
import seop.com.stockportfolio.member.domain.entity.Member;
import seop.com.stockportfolio.member.repository.MemberRepository;
import seop.com.stockportfolio.member.service.MemberService;

@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public String insert(Member member) {
        memberRepository.save(member);
        return "ok";
    }

    @Override
    public String findOneById(String id) {
        return memberRepository.findOneById(id);
    }
}
