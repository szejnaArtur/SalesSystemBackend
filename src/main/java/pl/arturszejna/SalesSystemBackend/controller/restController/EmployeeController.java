package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeDTO;
import pl.arturszejna.SalesSystemBackend.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/findByPIN/{PIN}")
    public EmployeeDTO findByPIN(@PathVariable String PIN){
        return employeeService.findByPIN(PIN);

    }

    @GetMapping("/findAllAtWork")
    public List<EmployeeDTO> findAllByEndWorkIsNull(){
        return employeeService.findAllByEndWorkIsNull();
    }
}
