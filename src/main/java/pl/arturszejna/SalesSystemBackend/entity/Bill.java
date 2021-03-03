package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.BillDTO;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmployee")
    private Employee employee;

    private Bill(Long idBill, LocalDateTime orderDate, LocalDateTime pickUpDate){
        this.idBill = idBill;
        this.orderDate = orderDate;
        this.pickUpDate = pickUpDate;
    }

    public Bill() {}

    public static Bill of(BillDTO dto){
        return new Bill(dto.getIdBill(), dto.getOrderDate(), dto.getPickUpDate());
    }

}
