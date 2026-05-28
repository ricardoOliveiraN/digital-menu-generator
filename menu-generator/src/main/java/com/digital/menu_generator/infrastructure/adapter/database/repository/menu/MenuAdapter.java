package com.digital.menu_generator.infrastructure.adapter.database.repository.menu;

import com.digital.menu_generator.application.port.out.menu.SaveMenuRepository;
import com.digital.menu_generator.domain.Menu;
import com.digital.menu_generator.domain.exceptions.menu.MenuPersistenceException;
import com.digital.menu_generator.infrastructure.adapter.database.entity.MenuEntity;
import com.digital.menu_generator.infrastructure.adapter.database.entity.UserEntity;
import jakarta.persistence.EntityManager;

public class MenuAdapter implements SaveMenuRepository {

    private final MenuRepository menuRepository;
    private final EntityManager entityManager;

    public MenuAdapter(MenuRepository menuRepository, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.menuRepository = menuRepository;
    }



    @Override
    public void saveMenu(Menu menu) {

        try {

            UserEntity userProxy = entityManager.getReference(UserEntity.class, menu.getIdUser());
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setName(menu.getNomeMenu());
            menuEntity.setUser(userProxy);
            menuRepository.save(menuEntity);

        } catch (Exception e) {
            throw  new MenuPersistenceException("Error saving menu for user: " + menu.getIdUser(), e);
        }

    }
}
