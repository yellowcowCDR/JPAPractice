package domain;

import com.sun.istack.NotNull;
import commonCode.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Orders extends BasicEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ORDER_ID")
    private Long id;

    @NotNull
    private LocalDateTime orderDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem){
        orderItem.setOrder(this);
        this.orderItems.add(orderItem);
    }

    /** 연관관계 편의 메소드 */
    public void changeMember(Member member){
        //기존에 연결된 연관관계 해제
        if(this.member != null){
            this.member.getOrders().remove(this);
        }

        this.setMember(member);
        member.getOrders().add(this);
    }
}
