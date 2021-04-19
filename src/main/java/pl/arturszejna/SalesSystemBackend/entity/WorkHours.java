package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.WorkHoursDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class WorkHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWorkHours;

    @Column
    private LocalDateTime startWork;

    @Column
    private LocalDateTime endWork;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmployee")
    private Employee employee;

    public static WorkHours of(WorkHoursDTO dto, Employee employee) {
        WorkHours workHours = new WorkHours();
        workHours.setIdWorkHours(dto.getIdWorkHours());
        workHours.setStartWork(dto.getStartWork());
        workHours.setEndWork(dto.getEndWork());
        workHours.setEmployee(employee);
        return workHours;
    }


}
