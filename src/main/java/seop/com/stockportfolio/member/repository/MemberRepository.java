package seop.com.stockportfolio.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seop.com.stockportfolio.member.domain.entity.Member;

public interface MemberRepository extends JpaRepository <Member, String> {

    String findOneById(String id);

}
