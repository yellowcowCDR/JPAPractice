package domain;

import lombok.*;

import javax.persistence.*;

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
}
