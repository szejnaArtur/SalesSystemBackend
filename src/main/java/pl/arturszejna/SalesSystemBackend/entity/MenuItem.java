package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private Long idMenuItem;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Integer kcal;

    @Column
    private String description;

    @Column
    private String type;

}
