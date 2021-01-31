package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeDTO;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.entity.WorkHours;
import pl.arturszejna.SalesSystemBackend.repository.EmployeeRepository;
import pl.arturszejna.SalesSystemBackend.repository.WorkHoursRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final WorkHoursRepository workHoursRepository;

    public EmployeeDTO findByPIN(String PIN) {
        Employee employee = employeeRepository.findEmployeeByPIN(PIN);
        EmployeeDTO employeeDTO;
        if (employee != null) {
            employeeDTO = EmployeeDTO.of(employee);
            employeeDTO.setAuthenticated(true);
        } else {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setAuthenticated(false);
        }
        return employeeDTO;
    }

    public List<EmployeeDTO> findAllByEndWorkIsNull() {
        List<WorkHours> allByEndWorkIsNull = workHoursRepository.findAllByEndWorkIsNull();
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (WorkHours workHours : allByEndWorkIsNull) {
            employeesDTO.add(EmployeeDTO.of(workHours.getEmployee()));
        }
        return employeesDTO;
    }
}
