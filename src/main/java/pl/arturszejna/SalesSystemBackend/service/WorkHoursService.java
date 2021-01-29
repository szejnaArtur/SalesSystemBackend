package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.arturszejna.SalesSystemBackend.dto.WorkHoursDTO;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.entity.WorkHours;
import pl.arturszejna.SalesSystemBackend.repository.EmployeeRepository;
import pl.arturszejna.SalesSystemBackend.repository.WorkHoursRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkHoursService {

    private final WorkHoursRepository workHoursRepository;
    private final EmployeeRepository employeeRepository;

    public WorkHoursDTO add(Long idEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(idEmployee);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            WorkHoursDTO dto = findFirstByEmployee(idEmployee);
            if (dto.getStartWork() == null) {
                dto.setStartWork(LocalDateTime.now());
                workHoursRepository.save(WorkHours.of(dto, employee));
            } else if (dto.getEndWork() == null) {
                dto.setEndWork(LocalDateTime.now());
                workHoursRepository.save(WorkHours.of(dto, employee));
            } else {
                WorkHoursDTO newDto = new WorkHoursDTO();
                newDto.setStartWork(LocalDateTime.now());
                workHoursRepository.save(WorkHours.of(newDto, employee));
                return newDto;
            }
            return dto;
        } else {
            throw new NullPointerException("Employee no exist.");
        }
    }

    public List<WorkHoursDTO> findAll() {
        List<WorkHours> allWorkHours = workHoursRepository.findAll();
        return allWorkHours.stream().map(WorkHoursDTO::of).collect(Collectors.toList());
    }

    public WorkHoursDTO findFirstByEmployee(Long idEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(idEmployee);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            List<WorkHours> allWorkHours = workHoursRepository.findAllByEmployee(employee);
            WorkHours workHours = allWorkHours.get(allWorkHours.size() - 1);
            return WorkHoursDTO.of(workHours);
        } else {
            throw new NullPointerException("Not found employee.");
        }
    }


}
