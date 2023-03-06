package domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="MEMBER_ID")
    private Long Id;
    private String name;
    private String city;
    private String street;
    private String zipcode;
    @OneToMany(mappedBy = "member")
    private List<Orders> orders;

    public void addOrder(Orders order){
        order.setMember(this);
        this.orders.add(order);
    }
}
