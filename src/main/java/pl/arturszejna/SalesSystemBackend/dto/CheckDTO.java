package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Bill;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CheckDTO {

    private Long idCheck;
    private LocalDateTime orderDate;
    private LocalDateTime pickUpDate;
    private EmployeeDTO employeeDTO;
    private List<OrderItemDTO> orderItemDTOList;

    public static CheckDTO of(Bill bill) {
        CheckDTO dto = new CheckDTO();
        dto.setIdCheck(bill.getIdBill());
        dto.setOrderDate(bill.getOrderDate());
        dto.setPickUpDate(bill.getPickUpDate());
        dto.setEmployeeDTO(EmployeeDTO.of(bill.getEmployee()));
        dto.setOrderItemDTOList(OrderItemDTO.of(bill.getOrderItems()));
        return dto;
    }

    public static List<CheckDTO> of(List<Bill> bills) {
        List<CheckDTO> dtoList = new ArrayList<>();
        for (Bill bill : bills) {
            dtoList.add(CheckDTO.of(bill));
        }
        return dtoList;
    }

}
