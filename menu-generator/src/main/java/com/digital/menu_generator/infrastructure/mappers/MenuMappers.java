package com.digital.menu_generator.infrastructure.mappers;

import com.digital.menu_generator.domain.Menu;
import com.digital.menu_generator.infrastructure.adapter.database.entity.MenuEntity;

public class MenuMappers {

    public Menu toDomain(MenuEntity entity){
        return new Menu(
            entity.getId(),
            entity.getUser().getId(),
            entity.getName()
        );
    }

}
