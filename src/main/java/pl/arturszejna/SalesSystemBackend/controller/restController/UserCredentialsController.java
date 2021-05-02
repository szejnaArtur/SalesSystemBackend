package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.dto.UserAuthenticationResultDTO;
import pl.arturszejna.SalesSystemBackend.dto.UserCredentialsDTO;
import pl.arturszejna.SalesSystemBackend.entity.UserCredentials;
import pl.arturszejna.SalesSystemBackend.service.UserCredentialsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credentials")
public class UserCredentialsController {

    private final UserCredentialsService userCredentialsService;

    @PostMapping("/add")
    public UserCredentials add() {
        UserCredentials userCredentials = new UserCredentials("anna", "buczkowicz");
        return userCredentialsService.signUpUserCredensials(userCredentials);
    }

    @GetMapping("/findAll")
    public List<UserCredentials> findAll() {
        return userCredentialsService.findAll();
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Long idUserCredentials) {
        return userCredentialsService.delete(idUserCredentials);
    }

    @PostMapping("/veryfy_user_credensials")
    public UserAuthenticationResultDTO verifyUserCedentials(@RequestBody UserCredentialsDTO userCredentialsDTO) {
        return userCredentialsService.verifyUserCedentials(userCredentialsDTO);
    }
}
