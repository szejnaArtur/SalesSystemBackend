package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserCredentials;

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private User user;

}
