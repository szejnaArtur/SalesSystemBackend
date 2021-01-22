package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeDTO;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.service.EmployeeService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/findByPIN/{PIN}")
    public EmployeeDTO findByPIN(@PathVariable String PIN){
        Employee employee = employeeService.findByPIN(PIN);
        EmployeeDTO employeeDTO;
        if(employee != null){
            employeeDTO = EmployeeDTO.of(employee);
            employeeDTO.setAuthenticated(true);
        } else {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setAuthenticated(false);
        }
        return employeeDTO;
    }
}
