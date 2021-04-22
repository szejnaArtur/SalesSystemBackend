package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.entity.Unit;
import pl.arturszejna.SalesSystemBackend.repository.QuantityTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuantityTypeService {

    private final QuantityTypeRepository quantityTypeRepository;

    public Unit add(Unit unit) {
        return quantityTypeRepository.save(unit);
    }

    public List<Unit> findAll() {
        return quantityTypeRepository.findAll();
    }

    public ResponseEntity delete(Long idQuantityType) {
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }
}
