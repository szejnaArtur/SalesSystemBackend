package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;

@Data
public class AverageBillAmountDTO {

    private EmployeeDTO employeeDTO;
    private Integer numberOfTransactions;
    private Double amount;

    public AverageBillAmountDTO(EmployeeDTO employeeDTO, Double amount){
        this.employeeDTO = employeeDTO;
        this.numberOfTransactions = 1;
        this.amount = amount;
    }

}
