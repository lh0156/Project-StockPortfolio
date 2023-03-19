package seop.com.stockportfolio.stock.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import seop.com.stockportfolio.member.domain.entity.Member;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name; // 주식 이름

    @Column
    private double price; // 구매 당시 가격

    @Column
    private LocalDate purchaseDate; // 구매일자

    @Column
    private int quantity; // 보유 수량

    @ManyToMany(mappedBy = "stocks")
    private Set<Member> members = new HashSet<>();

}
