package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.entity.WorkHours;

import java.time.LocalDateTime;

@Data
public class WorkHoursDTO {

    private Long idWorkHours;
    private LocalDateTime startWork;
    private LocalDateTime endWork;

    public static WorkHoursDTO of(WorkHours workHours){
        WorkHoursDTO dto = new WorkHoursDTO();
        dto.setIdWorkHours(workHours.getIdWorkHours());
        dto.setStartWork(workHours.getStartWork());
        dto.setEndWork(workHours.getEndWork());
        return dto;
    }
}
