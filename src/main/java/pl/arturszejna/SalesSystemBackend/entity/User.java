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

    @Column
    private String email;

    @Column
    private Integer phone;

    @OneToOne(mappedBy = "user")
    private UserCredentials userCredentials;

    public User(String firstName, String lastName, String email, Integer phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public User(){}

}
