package seop.com.stockportfolio.member.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seop.com.stockportfolio.member.domain.entity.Member;
import seop.com.stockportfolio.member.repository.MemberRepository;
import seop.com.stockportfolio.member.service.MemberService;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findOneById(String id) {
        return memberRepository.findOneById(id);
    }
}
