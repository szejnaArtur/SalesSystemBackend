package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class EmployeeCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmployeeCredentials;

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name= "idEmployee")
    private Employee employee;

}
