package seop.com.stockportfolio.member.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import seop.com.stockportfolio.stock.domain.entity.Stock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "stock_name")
    private Stock stock;

    public Member(String id, String name, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

}
