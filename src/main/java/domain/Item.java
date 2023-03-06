package domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Item extends BasicEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ITEM_ID")
    private Long id;
    @NotNull
    private String name;
    private Integer price;
    private Integer stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems;

    public void addOrderItem(OrderItem orderItem){

    }
}
