package com.digital.menu_generator.infrastructure.adapter.database.repository.menu;

import com.digital.menu_generator.domain.Menu;
import com.digital.menu_generator.infrastructure.adapter.database.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("DELETE FROM MenuEntity m WHERE m.id = :idMenu AND m.user.id = :idUser")
    int deleteByIdAndUserId(@Param("idMenu") UUID idMenu, @Param("idUser") UUID idUser);

    @Query("SELECT FROM MenuEntity m WHERE m.id = :idMenu AND m.user.id = :idUser")
    MenuEntity findByIdAndUserId(@Param("idMenu") UUID idMenu, @Param("idUser") UUID idUser);

}
