package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeAuthenticationResultDTO;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeCredentialsDTO;
import pl.arturszejna.SalesSystemBackend.entity.EmployeeCredentials;
import pl.arturszejna.SalesSystemBackend.service.EmployeeCredentialsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credentials")
public class EmployeeCredentialsController {

    private final EmployeeCredentialsService employeeCredentialsService;

    @PostMapping("/add")
    public EmployeeCredentials add(@RequestBody EmployeeCredentials employeeCredentials) {
        return employeeCredentialsService.add(employeeCredentials);
    }

    @GetMapping("/findAll")
    public List<EmployeeCredentials> findAll() {
        return employeeCredentialsService.findAll();
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Long idEmployeeCredentials) {
        return employeeCredentialsService.delete(idEmployeeCredentials);
    }

    @PostMapping("/veryfy_employee_credensials")
    public EmployeeAuthenticationResultDTO verifyEmployeeCedentials(@RequestBody EmployeeCredentialsDTO employeeCredentialsDTO){
        return employeeCredentialsService.verifyEmployeeCedentials(employeeCredentialsDTO);
    }
}
