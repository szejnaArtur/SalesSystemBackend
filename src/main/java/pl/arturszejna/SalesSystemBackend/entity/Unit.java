package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnit;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unit")
    private List<Product> products;

}
