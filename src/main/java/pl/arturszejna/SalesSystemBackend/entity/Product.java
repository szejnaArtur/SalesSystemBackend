package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUnit")
    private Unit unit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategory")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Recipe> recipes;


}
