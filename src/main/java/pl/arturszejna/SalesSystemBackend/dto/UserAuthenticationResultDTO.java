package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.UserCredentials;

@Data
public class UserAuthenticationResultDTO {

    private Long idUser;
    private String firstName;
    private String lastName;
    private boolean authenticated;

    public static UserAuthenticationResultDTO createUnauthnticated() {
        UserAuthenticationResultDTO dto = new UserAuthenticationResultDTO();
        dto.setAuthenticated(false);
        return dto;
    }

    public static UserAuthenticationResultDTO of(UserCredentials userCredentials) {
        UserAuthenticationResultDTO dto = new UserAuthenticationResultDTO();
        dto.setFirstName(userCredentials.getUser().getFirstName());
        dto.setLastName(userCredentials.getUser().getLastName());
        dto.setAuthenticated(true);
        dto.setIdUser(userCredentials.getUser().getIdUser());
        return dto;
    }

}