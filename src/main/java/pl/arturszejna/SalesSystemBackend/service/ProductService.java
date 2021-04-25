package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.ProductDTO;
import pl.arturszejna.SalesSystemBackend.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        return ProductDTO.of(productRepository.findAll());
    }

    public List<ProductDTO> findAllByCategory_Id(Long id) {
        return ProductDTO.of(productRepository.findAllByCategory_IdCategory(id));
    }

    public List<ProductDTO> findAllByCategory_Name(String name) {
        return ProductDTO.of(productRepository.findAllByCategory_Name(name));
    }

}
