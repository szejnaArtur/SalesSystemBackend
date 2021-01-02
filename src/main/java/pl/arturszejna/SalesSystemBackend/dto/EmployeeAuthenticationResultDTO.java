package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.EmployeeCredentials;

@Data
public class EmployeeAuthenticationResultDTO {

    private Long idEmployee;
    private String firstName;
    private String lastName;
    private boolean authenticated;

    public static EmployeeAuthenticationResultDTO createUnauthnticated(){
        EmployeeAuthenticationResultDTO dto = new EmployeeAuthenticationResultDTO();
        dto.setAuthenticated(false);
        return dto;
    }

    public static EmployeeAuthenticationResultDTO of(EmployeeCredentials employeeCredentials){
        EmployeeAuthenticationResultDTO dto = new EmployeeAuthenticationResultDTO();
        dto.setFirstName(employeeCredentials.getEmployee().getFirstName());
        dto.setLastName(employeeCredentials.getEmployee().getLastName());
        dto.setAuthenticated(true);
        dto.setIdEmployee(employeeCredentials.getEmployee().getIdEmployee());
        return dto;
    }

}