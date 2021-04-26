package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.dto.AverageBillAmountDTO;
import pl.arturszejna.SalesSystemBackend.dto.BillDTO;
import pl.arturszejna.SalesSystemBackend.service.BillService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "bills")
public class BillController {

    private final BillService billService;

    @GetMapping("/findAll")
    public List<BillDTO> findAll() {
        return billService.findAll();
    }

    @GetMapping("/find/{id}")
    public BillDTO findById(@PathVariable Long id) {
        return billService.findById(id);
    }

    @PostMapping("/add")
    public BillDTO save(@RequestBody BillDTO billDTO) {
        return billService.save(billDTO);
    }

    @GetMapping("/AGC")
    public List<AverageBillAmountDTO> showAGCRaport() {
        return billService.createAGCRaport();
    }

    @GetMapping("/perfectConsumption")
    public Map<String, Double> perfectConsumption() {
        return billService.perfectConsumptionOfTheProduct();
    }

}
