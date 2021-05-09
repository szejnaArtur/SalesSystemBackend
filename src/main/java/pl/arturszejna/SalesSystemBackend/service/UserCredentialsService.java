package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.arturszejna.SalesSystemBackend.component.mailer.RandomStringFactory;
import pl.arturszejna.SalesSystemBackend.component.mailer.SignUpMailer;
import pl.arturszejna.SalesSystemBackend.dto.UserAuthenticationResultDTO;
import pl.arturszejna.SalesSystemBackend.dto.UserCredentialsDTO;
import pl.arturszejna.SalesSystemBackend.entity.Role;
import pl.arturszejna.SalesSystemBackend.entity.UserCredentials;
import pl.arturszejna.SalesSystemBackend.repository.RoleRepository;
import pl.arturszejna.SalesSystemBackend.repository.UserCredentialsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCredentialsService {

    private static final int TOKEN_LENGTH = 20;
    private final UserCredentialsRepository userCredentialsRepository;
    private final PasswordEncoder passwordEncoder;
    private final SignUpMailer mailer;
    private final RoleRepository roleRepository;

    public UserCredentials add(UserCredentials userCredentials) {
        return userCredentialsRepository.save(userCredentials);
    }

    public List<UserCredentials> findAll() {
        return userCredentialsRepository.findAll();
    }

    public ResponseEntity delete(Long idUserCredentials) {
        userCredentialsRepository.deleteById(idUserCredentials);
        return ResponseEntity.ok().build();
    }

    public UserAuthenticationResultDTO verifyUserCedentials(UserCredentialsDTO userCredentialsDTO) {
        Optional<UserCredentials> optionalUserCredentials =
                userCredentialsRepository.findByLogin(userCredentialsDTO.getLogin());
        if (!optionalUserCredentials.isPresent()) {
            System.out.println("nie znaleziono takiego loginu.");
            return UserAuthenticationResultDTO.createUnauthnticated();
        } else {
            UserCredentials userCredentials = optionalUserCredentials.get();
            if (!userCredentials.getPassword().equals(userCredentialsDTO.getPassword())) {
                System.out.println("hasło jest nieprawidłowe");
                return UserAuthenticationResultDTO.createUnauthnticated();
            } else {
                return UserAuthenticationResultDTO.of(userCredentials);
            }
        }
    }

    public UserCredentials signUpUserCredensials(UserCredentials userCredentials) {
        Assert.isNull(userCredentials.getIdUserCredentials(), "Can't sign up given user, it already has set id. User: "
                + userCredentials.getUsername());
        Optional<UserCredentials> optionalUser = userCredentialsRepository.findByLogin(userCredentials.getLogin());
        if (!optionalUser.isPresent()) {
            userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
            String token = RandomStringFactory.getRandomString(TOKEN_LENGTH);
            userCredentials.setConfirmationToken(token);
            Optional<Role> roleOptional = roleRepository.findByName("JUNIOR_MANAGER");
            roleOptional.ifPresent(role -> userCredentials.getRoles().add(role));
            mailer.sendConfirmationLink(userCredentials.getUser().getEmail(), token);
            userCredentialsRepository.save(userCredentials);
        }
        return userCredentials;
    }

}
