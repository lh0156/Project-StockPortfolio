package seop.com.stockportfolio.member.domain.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Member {

    @Id
    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String phoneNumber;

}
