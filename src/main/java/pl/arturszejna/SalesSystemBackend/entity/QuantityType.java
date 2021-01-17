package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class QuantityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuantityType;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quantityType")
    private List<Product> products;

}
