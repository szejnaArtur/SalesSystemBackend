package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBill;

    @Column
    private LocalDateTime orderDate;

    @Column
    private LocalDateTime pickUpDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
    private List<OrderItem> orderItems;
}
