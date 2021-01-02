package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arturszejna.SalesSystemBackend.entity.QuantityType;
import pl.arturszejna.SalesSystemBackend.repository.QuantityTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuantityTypeService {

    private final QuantityTypeRepository quantityTypeRepository;

    public QuantityType add(QuantityType quantityType){
        return quantityTypeRepository.save(quantityType);
    }

    public List<QuantityType> findAll(){
        return quantityTypeRepository.findAll();
    }

    public ResponseEntity delete(Long idQuantityType){
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }
}
