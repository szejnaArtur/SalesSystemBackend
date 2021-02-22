package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderItem;

    @Column
    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMenuItem")
    private MenuItem menuItem;

}
