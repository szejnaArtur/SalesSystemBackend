package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Bill;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class BillDTO {

    private Long idBill;
    private LocalDateTime orderDate;
    private LocalDateTime pickUpDate;
    private EmployeeDTO employeeDTO;
    private Long texID;
    private Double cashPaymentAmount;
    private Double cardPaymentAmount;
    private Double payUPaymentAmount;
    private Double sodexoPaymentAmount;

    private BillDTO(Long idBill, LocalDateTime orderDate, LocalDateTime pickUpDate, EmployeeDTO employeeDTO, Long texID,
                    Double cashPaymentAmount, Double cardPaymentAmount, Double payUPaymentAmount, Double sodexoPaymentAmount){
        this.idBill = idBill;
        this.orderDate = orderDate;
        this.pickUpDate = pickUpDate;
        this.employeeDTO = employeeDTO;
        this.texID = texID;
        this.cashPaymentAmount = cashPaymentAmount;
        this.cardPaymentAmount = cardPaymentAmount;
        this.payUPaymentAmount = payUPaymentAmount;
        this.sodexoPaymentAmount = sodexoPaymentAmount;
    }

    public static BillDTO of(Bill bill){
        return new BillDTO(bill.getIdBill(), bill.getOrderDate(), bill.getPickUpDate(), EmployeeDTO.of(bill.getEmployee()),
                bill.getTexID(), bill.getCashPaymentAmount(), bill.getCardPaymentAmount(), bill.getPayUPaymentAmount(),
                bill.getSodexoPaymentAmount());
    }

    public static List<BillDTO> of(List<Bill> billList) {
        List<BillDTO> dtoList = new ArrayList<>();
        for (Bill bill : billList) {
            dtoList.add(BillDTO.of(bill));
        }
        return dtoList;
    }
}
