package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.UserAuthenticationResultDTO;
import pl.arturszejna.SalesSystemBackend.dto.UserCredentialsDTO;
import pl.arturszejna.SalesSystemBackend.entity.UserCredentials;
import pl.arturszejna.SalesSystemBackend.repository.UserCredentialsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCredentialsService {

    private final UserCredentialsRepository userCredentialsRepository;

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

}
