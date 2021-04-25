package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {

    private Long idProduct;
    private String name;
    private UnitDTO unit;
    private CategoryDTO category;

    private ProductDTO(Long idProduct, String name, UnitDTO unit, CategoryDTO category){
        setIdProduct(idProduct);
        setName(name);
        setUnit(unit);
        setCategory(category);
    }

    public static ProductDTO of(Product product){
        return new ProductDTO(product.getIdProduct(), product.getName(),
                UnitDTO.of(product.getUnit()), CategoryDTO.of(product.getCategory()));
    }

    public static List<ProductDTO> of(List<Product> productList){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList){
            productDTOList.add(ProductDTO.of(product));
        }
        return productDTOList;
    }
}
