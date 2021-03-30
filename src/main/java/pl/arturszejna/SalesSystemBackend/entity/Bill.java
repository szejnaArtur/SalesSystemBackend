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

    @Column
    private Long texID;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmployee")
    private Employee employee;

    @Column
    private Double cashPaymentAmount;

    @Column
    private Double cardPaymentAmount;

    @Column
    private Double payUPaymentAmount;

    @Column
    private Double sodexoPaymentAmount;

    private Bill(Long idBill, LocalDateTime orderDate, LocalDateTime pickUpDate, Employee employee, Long texID,
                 Double cashPaymentAmount, Double cardPaymentAmount, Double payUPaymentAmount, Double sodexoPaymentAmount){
        this.idBill = idBill;
        this.orderDate = orderDate;
        this.pickUpDate = pickUpDate;
        this.employee = employee;
        this.texID = texID;
        this.cashPaymentAmount = cashPaymentAmount;
        this.cardPaymentAmount = cardPaymentAmount;
        this.payUPaymentAmount = payUPaymentAmount;
        this.sodexoPaymentAmount = sodexoPaymentAmount;
    }

    public Bill() {}

    public static Bill of(BillDTO dto){
        return new Bill(dto.getIdBill(), dto.getOrderDate(), dto.getPickUpDate(), Employee.of(dto.getEmployeeDTO()),
                dto.getTexID(), dto.getCashPaymentAmount(), dto.getCardPaymentAmount(), dto.getPayUPaymentAmount(),
                dto.getSodexoPaymentAmount());
    }

}
