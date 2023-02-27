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
}
