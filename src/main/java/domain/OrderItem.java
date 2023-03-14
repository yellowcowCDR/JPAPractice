package domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Order;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderItem extends BasicEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ORDERITEM_ID")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Orders order;

    @NotNull
    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;

    private Integer orderPrice;

    private Integer count;

    /** 연관관계 편의 메소드 */
    public void changeOrder(Orders order){
        //기존에 연결된 연관관계 해제
        if(this.order != null){
            this.order.getOrderItems().remove(this);
        }

        this.setOrder(order);
        order.getOrderItems().add(this);
    }

    /** 연관관계 편의 메소드 */
    public void changeItem(Item item){
        //기존에 연결된 연관관계 해제
        if(this.item != null){
            this.item.getOrderItems().remove(this);
        }

        this.setItem(item);
        item.getOrderItems().add(this);
    }
}
