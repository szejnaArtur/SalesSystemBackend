package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Employee;

@Data
public class EmployeeDTO {

    private Long idEmployee;
    private String firstName;
    private String lastName;
    private String PIN;
    private boolean authenticated;

    public static EmployeeDTO of(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setIdEmployee(employee.getIdEmployee());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setPIN(employee.getPIN());
        return dto;
    }
}
