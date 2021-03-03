package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

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

}
