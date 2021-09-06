package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeDTO;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return EmployeeDTO.of(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return employeeService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setIdEmployee(id);
        return employeeService.save(employee);
    }

    @GetMapping
    public List<EmployeeDTO> findAll(){
        List<Employee> all = employeeService.findAll();
        List<EmployeeDTO> dto = new ArrayList<>();
        for(Employee employee : all){
            dto.add(EmployeeDTO.of(employee));
        }
        return dto;
    }

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable Long id){
        return EmployeeDTO.of(employeeService.findById(id));
    }

    @GetMapping("/findByPIN/{PIN}")
    public EmployeeDTO findByPIN(@PathVariable String PIN) {
        return employeeService.findByPIN(PIN);
    }

    @GetMapping("/findAllAtWork")
    public List<EmployeeDTO> findAllByEndWorkIsNull(){
        return employeeService.findAllByEndWorkIsNull();
    }
}
