package com.digital.menu_generator.infrastructure.adapter.database.repository.item;
import com.digital.menu_generator.application.port.out.item.DeleteItemRepository;
import com.digital.menu_generator.domain.exceptions.item.ItemConflictException;
import com.digital.menu_generator.domain.exceptions.item.ItemNotFoundException;
import com.digital.menu_generator.domain.exceptions.item.ItemPersistenceException;
import com.digital.menu_generator.infrastructure.mappers.ItemMappers;
import com.digital.menu_generator.application.port.out.item.SaveItemRepository;
import com.digital.menu_generator.domain.Item;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

public class ItemAdapter implements SaveItemRepository, DeleteItemRepository {

    private final ItemRepository itemRepository;
    private final ItemMappers mappers;

    public ItemAdapter(ItemRepository itemRepository, ItemMappers mappers) {
        this.itemRepository = itemRepository;
        this.mappers = mappers;
    }


    @Override
    public void saveItem(Item item) {
        try{
            itemRepository.saveAndFlush(mappers.toEntity(item));
        }catch(DataIntegrityViolationException e){
            throw new ItemConflictException("Item position or path already exists for item with id:" + item.getId() + " and menu id: " + item.getIdMenu(), e);
        }catch (Exception e) {
            throw new ItemPersistenceException("Error saving item for menu:" + item.getIdMenu(), e);
        }
    }

    @Override
    public void deleteItem(UUID idItem, UUID idMenu) {
        try{

            int rowsAffected = itemRepository.deleteByIdAndMenuId(idItem, idMenu);
            if(rowsAffected == 0) {
                throw new ItemNotFoundException("No item found with ID: " + idItem + " for menu: " + idMenu);
            }

        }catch(ItemNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new ItemPersistenceException("Error deleting item with ID: " + idItem + " for menu: " + idMenu, e);
        }
    }
}
