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

    private BillDTO(Long idBill, LocalDateTime orderDate, LocalDateTime pickUpDate){
        this.idBill = idBill;
        this.orderDate = orderDate;
        this.pickUpDate = pickUpDate;
    }

    public static BillDTO of(Bill bill){
        return new BillDTO(bill.getIdBill(), bill.getOrderDate(), bill.getPickUpDate());
    }

    public static List<BillDTO> of(List<Bill> billList){
        List<BillDTO> dtoList = new ArrayList<>();
        for(Bill bill : billList){
            dtoList.add(BillDTO.of(bill));
        }
        return dtoList;
    }
}
