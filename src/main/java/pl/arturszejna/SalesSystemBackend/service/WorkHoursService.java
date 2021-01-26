package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.WorkHoursDTO;
import pl.arturszejna.SalesSystemBackend.entity.WorkHours;
import pl.arturszejna.SalesSystemBackend.repository.WorkHoursRepository;

@Service
@RequiredArgsConstructor
public class WorkHoursService {

    private final WorkHoursRepository workHoursRepository;

    public WorkHoursDTO add(WorkHours workHours){
        workHoursRepository.save(workHours);
        return WorkHoursDTO.of(workHours);
    }
}
