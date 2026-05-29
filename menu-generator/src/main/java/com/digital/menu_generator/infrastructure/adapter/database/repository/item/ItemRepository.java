package com.digital.menu_generator.infrastructure.adapter.database.repository.item;

import com.digital.menu_generator.infrastructure.adapter.database.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
}
