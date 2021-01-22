package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne(mappedBy = "user")
    private UserCredentials userCredentials;

}
