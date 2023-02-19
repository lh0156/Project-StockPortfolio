package seop.com.stockportfolio.stock.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import seop.com.stockportfolio.member.domain.entity.Member;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Stock {

    @Id
    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Integer count;

    @OneToMany(mappedBy = "stock")
    private List<Member> member;

    public Stock(String name, Double price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }


}
