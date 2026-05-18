package com.digital.menu_generator.infrastructure.adapter.database.repository.menu;

import com.digital.menu_generator.infrastructure.adapter.database.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {
}
