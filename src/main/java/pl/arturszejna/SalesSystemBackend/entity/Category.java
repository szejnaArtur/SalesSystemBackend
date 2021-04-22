package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products;



}
