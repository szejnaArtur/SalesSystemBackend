package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.*;
import pl.arturszejna.SalesSystemBackend.entity.Bill;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.repository.AddonRepository;
import pl.arturszejna.SalesSystemBackend.repository.BillRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddonService {

    public final AddonRepository addonRepository;


    public List<AddonDTO> findAll() {
        return AddonDTO.of(addonRepository.findAll());
    }

}
