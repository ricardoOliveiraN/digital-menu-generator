package com.digital.menu_generator.infrastructure.adapter.database.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "itens",

         uniqueConstraints = {
                @UniqueConstraint(columnNames = {"fk_menu", "position_screen"}),
                 @UniqueConstraint(name = "uk_item_menu_image_path", columnNames = {"fk_menu", "imagePath"})
         }

)
@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_menu")
    private MenuEntity menu;

    private String name;
    private String description;
    private BigDecimal cost;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "position_screen")
    private Integer positionScreen;

    public ItemEntity(MenuEntity menu, String name, String description, BigDecimal cost, String imagePath, Integer positionScreen) {
        this.menu = menu;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.imagePath = imagePath;
        this.positionScreen = positionScreen;
    }

}
