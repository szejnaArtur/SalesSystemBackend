package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.entity.Product;
import pl.arturszejna.SalesSystemBackend.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product add(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public ResponseEntity delete(Long idItem) {
        productRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

}
