package com.digital.menu_generator.infrastructure.adapter.database.repository.item;
import com.digital.menu_generator.domain.exceptions.item.ItemConflictException;
import com.digital.menu_generator.domain.exceptions.item.ItemPersistenceException;
import com.digital.menu_generator.infrastructure.mappers.ItemMappers;
import com.digital.menu_generator.application.port.out.item.SaveItemRepository;
import com.digital.menu_generator.domain.Item;
import org.springframework.dao.DataIntegrityViolationException;

public class ItemAdapter implements SaveItemRepository {

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
}
