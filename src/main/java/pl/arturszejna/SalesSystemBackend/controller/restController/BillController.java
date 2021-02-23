package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.BillDTO;
import pl.arturszejna.SalesSystemBackend.service.BillService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "bills")
public class BillController {

    private final BillService billService;

    @GetMapping("/findAll")
    public List<BillDTO> findAll(){
        return billService.findAll();
    }

    @GetMapping("/find/{id}")
    public BillDTO findById(@PathVariable Long id){
        return billService.findById(id);
    }

}
