package com.digital.menu_generator.infrastructure.mappers;

import com.digital.menu_generator.domain.Item;
import com.digital.menu_generator.infrastructure.adapter.database.entity.ItemEntity;
import com.digital.menu_generator.infrastructure.adapter.database.entity.MenuEntity;
import jakarta.persistence.EntityManager;

public class ItemMappers {
    private final EntityManager entityManager;

    public ItemMappers(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ItemEntity toEntity(Item item){

        MenuEntity menu = entityManager.getReference(MenuEntity.class, item.getId());

        return new ItemEntity(
                menu,
                item.getNomeItem(),
                item.getDescricaoItem(),
                item.getPrecoItem(),
                item.getImagePath(),
                item.getPosicaoTela()
        );

    }

}
