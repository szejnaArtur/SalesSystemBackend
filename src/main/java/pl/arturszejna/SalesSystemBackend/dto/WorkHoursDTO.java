package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.entity.WorkHours;

import java.util.Date;

@Data
public class WorkHoursDTO {

    private Long idWorkHours;
    private Date startWork;
    private Date endWork;
    private Employee employee;

    public static WorkHoursDTO of(WorkHours workHours){
        WorkHoursDTO dto = new WorkHoursDTO();
        dto.setIdWorkHours(workHours.getIdWorkHours());
        dto.setStartWork(workHours.getStartWork());
        dto.setEndWork(workHours.getEndWork());
        dto.setEmployee(workHours.getEmployee());
        return dto;
    }
}
