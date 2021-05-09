package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    Set<UserCredentials> userCredentialsSet;


}
