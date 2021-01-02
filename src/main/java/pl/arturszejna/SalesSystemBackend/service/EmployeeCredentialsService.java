package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeAuthenticationResultDTO;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeCredentialsDTO;
import pl.arturszejna.SalesSystemBackend.entity.EmployeeCredentials;
import pl.arturszejna.SalesSystemBackend.repository.EmployeeCredentialsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeCredentialsService {

    private final EmployeeCredentialsRepository employeeCredentialsRepository;

    public EmployeeCredentials add(EmployeeCredentials employeeCredentials){
        return employeeCredentialsRepository.save(employeeCredentials);
    }

    public List<EmployeeCredentials> findAll(){
        return employeeCredentialsRepository.findAll();
    }

    public ResponseEntity delete(Long idEmployeeCredentials){
        employeeCredentialsRepository.deleteById(idEmployeeCredentials);
        return ResponseEntity.ok().build();
    }

    public EmployeeAuthenticationResultDTO verifyEmployeeCedentials(EmployeeCredentialsDTO employeeCredentialsDTO){
        Optional<EmployeeCredentials> optionalEmployeeCredentials =
                employeeCredentialsRepository.findByLogin(employeeCredentialsDTO.getLogin());
        if(!optionalEmployeeCredentials.isPresent()){
            System.out.println("nie znaleziono takiego loginu.");
            return EmployeeAuthenticationResultDTO.createUnauthnticated();
        } else {
            EmployeeCredentials employeeCredentials = optionalEmployeeCredentials.get();
            if (!employeeCredentials.getPassword().equals(employeeCredentialsDTO.getPassword())){
                System.out.println("hasło jest nieprawidłowe");
                return EmployeeAuthenticationResultDTO.createUnauthnticated();
            } else {
                return EmployeeAuthenticationResultDTO.of(employeeCredentials);
            }
        }

    }

}
