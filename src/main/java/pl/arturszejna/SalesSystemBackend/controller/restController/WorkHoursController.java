package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.dto.WorkHoursDTO;
import pl.arturszejna.SalesSystemBackend.service.WorkHoursService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/workHours")
public class WorkHoursController {

    private final WorkHoursService workHoursService;

    @PostMapping(value = "/add/{idEmployee}")
    public WorkHoursDTO add(@PathVariable Long idEmployee) {
        return workHoursService.add(idEmployee);
    }

    @GetMapping(value = "/findAll")
    public List<WorkHoursDTO> findAll() {
        return workHoursService.findAll();
    }

    @GetMapping(value = "/findFirst/{idEmployee}")
    public WorkHoursDTO findFirst(@PathVariable Long idEmployee) {
        return workHoursService.findFirstByEmployee(idEmployee);
    }

}
