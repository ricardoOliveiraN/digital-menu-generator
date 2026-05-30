package com.digital.menu_generator.infrastructure.adapter.database.repository.menu;

import com.digital.menu_generator.application.port.out.menu.DeleteMenuRepository;
import com.digital.menu_generator.application.port.out.menu.ReadMenuRepository;
import com.digital.menu_generator.application.port.out.menu.SaveMenuRepository;
import com.digital.menu_generator.domain.Menu;
import com.digital.menu_generator.domain.exceptions.menu.MenuInUseException;
import com.digital.menu_generator.domain.exceptions.menu.MenuNotFoundExcepetion;
import com.digital.menu_generator.domain.exceptions.menu.MenuPersistenceException;
import com.digital.menu_generator.infrastructure.adapter.database.entity.MenuEntity;
import com.digital.menu_generator.infrastructure.adapter.database.entity.UserEntity;
import com.digital.menu_generator.infrastructure.mappers.MenuMappers;
import jakarta.persistence.EntityManager;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

public class MenuAdapter implements SaveMenuRepository, DeleteMenuRepository, ReadMenuRepository {

    private final MenuRepository menuRepository;
    private final EntityManager entityManager;
    private final MenuMappers menuMappers;

    public MenuAdapter(MenuRepository menuRepository, EntityManager entityManager, MenuMappers menuMappers) {
        this.entityManager = entityManager;
        this.menuRepository = menuRepository;
        this.menuMappers = menuMappers;
    }



    @Override
    public void saveMenu(Menu menu) {

        try {

            UserEntity userProxy = entityManager.getReference(UserEntity.class, menu.getIdUser());
            MenuEntity menuEntity = new MenuEntity(menu.getNomeMenu(), userProxy);
            menuRepository.saveAndFlush(menuEntity);

        }catch (Exception e) {
            throw  new MenuPersistenceException("Error saving menu for user: " + menu.getIdUser(), e);
        }

    }

    @Override
    public void deleteMenu(UUID idMenu, UUID idUser) {
        try{
            int rowsAffected = menuRepository.deleteByIdAndUserId(idMenu, idUser);

            if(rowsAffected == 0) {
                throw new MenuNotFoundExcepetion("No menu found with ID: " + idMenu + " for user: " + idUser);
            }

        } catch (MenuNotFoundExcepetion e) {
            throw e;
        }catch(DataIntegrityViolationException e){
            throw new MenuInUseException("Cannot delete menu with ID: " + idMenu + " for user: " + idUser + " because it is in use.", e);
        }catch (Exception e) {
            throw new MenuPersistenceException("Error deleting menu with ID: " + idMenu + " for user: " + idUser, e);
        }
    }

    @Override
    public Menu readMenu(UUID idMenu, UUID idUser) {
        try{

            MenuEntity menu = menuRepository.findByIdAndUserId(idMenu, idUser);

            if(menu == null) {
                throw new MenuNotFoundExcepetion("No menu found with ID: " + idMenu + " for user: " + idUser);
            }

            return menuMappers.toDomain(menu);
        }catch(MenuNotFoundExcepetion e){
            throw e;
        }catch(Exception e) {
            throw new MenuPersistenceException("Error reading menu with ID: " + idMenu + " for user: " + idUser, e);
        }


    }
}
