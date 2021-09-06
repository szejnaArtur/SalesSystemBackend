package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String PIN;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<WorkHours> workHours;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Bill> bills;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String PIN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;
    }

    private Employee(Long idEmployee, String firstName, String lastName, String PIN) {
        this.idEmployee = idEmployee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;
    }

    public static Employee of(EmployeeDTO dto) {
        return new Employee(dto.getIdEmployee(), dto.getFirstName(), dto.getLastName(), dto.getPIN());
    }

}
