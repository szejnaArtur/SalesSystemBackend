package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecipe;

    @Column
    private Double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMenuItem")
    private MenuItem menuItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct")
    private Product product;


}
