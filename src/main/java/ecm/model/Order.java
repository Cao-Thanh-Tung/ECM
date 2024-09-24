package ecm.model;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private String contactName;

    private String deliveryAddress;

    private String ccName;

    private String ccNumber;

    private String ccExpiryDate;
}