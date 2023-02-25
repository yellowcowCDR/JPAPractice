package domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private Long orderId;

    @NotNull
    private Long itemId;
}
