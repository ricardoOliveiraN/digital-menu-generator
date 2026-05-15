package com.digital.menu_generator.infrastructure.adapter.database.repository.user;

import com.digital.menu_generator.application.port.out.user.GetUserDetailsRepository;
import com.digital.menu_generator.domain.User;
import com.digital.menu_generator.infrastructure.mappers.UserMappers;

import java.util.UUID;

public class UserAdapter implements GetUserDetailsRepository {

    private UserRepository userRepository;
    private UserMappers userMappers;

    public UserAdapter(UserRepository userRepository, UserMappers userMappers) {
        this.userRepository = userRepository;
        this.userMappers = userMappers;
    }


    @Override
    public User findUser(UUID userId) {
        return userRepository.findById(userId)
                .map(userMappers::toDomain)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

    }
}
