package com.digital.menu_generator.infrastructure.adapter.database.repository.item;

import com.digital.menu_generator.infrastructure.adapter.database.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("DELETE FROM ItemEntity i WHERE i.id = :idItem AND i.menu.id = :idMenu")
    int deleteByIdAndMenuId(@Param("idItem") UUID idItem, @Param("idMenu") UUID idMenu);

}
