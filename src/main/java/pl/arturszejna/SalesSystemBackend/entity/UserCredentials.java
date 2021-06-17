package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
public class UserCredentials implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserCredentials;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String confirmationToken;

    @Column(columnDefinition = "boolean default false")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userCredential_rolers", joinColumns = @JoinColumn(name = "idUserCredentials"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    Set<Role> roles;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private User user;

    public UserCredentials(String login, String password, User user) {
        super();
        this.login = login;
        this.password = password;
        this.user = user;
        this.enabled = false;
        this.roles = new HashSet<>();
    }

    public UserCredentials(String username, String password) {
        this.login = username;
        this.password = password;
        this.enabled = false;
        this.roles = new HashSet<>();
    }

    public UserCredentials() {
        this.enabled = false;
        this.roles = new HashSet<>();
    }

    public static UserCredentials of(String firstName, String lastName, String email, String username, String password, Integer phone) {
        return new UserCredentials(username, password, new User(firstName, lastName, email, phone));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
