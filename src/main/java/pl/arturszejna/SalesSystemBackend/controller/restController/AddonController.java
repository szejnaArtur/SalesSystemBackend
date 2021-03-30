package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.AddonDTO;
import pl.arturszejna.SalesSystemBackend.service.AddonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/addon")
public class AddonController {

    private final AddonService addonService;

    @GetMapping("/findAll")
    public List<AddonDTO> findAll() {
        return addonService.findAll();

    }

}
