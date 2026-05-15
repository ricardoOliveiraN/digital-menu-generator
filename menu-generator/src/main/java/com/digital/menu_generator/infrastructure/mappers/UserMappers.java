package com.digital.menu_generator.infrastructure.mappers;

import com.digital.menu_generator.domain.User;
import com.digital.menu_generator.infrastructure.adapter.database.entity.UserEntity;

public class UserMappers {

    public User toDomain(UserEntity userEntity){
        return new User(
            userEntity.getId(),
            userEntity.getName(),
            userEntity.getEmail(),
            userEntity.getTelefone(),
            userEntity.getQuantidadeMenus(),
            userEntity.getUrlLogoStorage(),
            userEntity.getNomeMarca()
        );
    }

}
