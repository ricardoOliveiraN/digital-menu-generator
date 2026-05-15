package com.digital.menu_generator.infrastructure.adapter.database.repository.user;

import com.digital.menu_generator.infrastructure.adapter.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {


}
