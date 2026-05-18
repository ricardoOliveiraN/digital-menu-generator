package com.digital.menu_generator.infrastructure.adapter.database.repository.user;

import com.digital.menu_generator.application.port.out.user.GetUserDetailsRepository;
import com.digital.menu_generator.application.port.out.user.SaveUserDetailsRepository;
import com.digital.menu_generator.domain.User;
import com.digital.menu_generator.domain.exceptions.UserNotFounException;
import com.digital.menu_generator.domain.exceptions.UserPersistenceException;
import com.digital.menu_generator.infrastructure.mappers.UserMappers;

import java.util.UUID;

public class UserAdapter implements GetUserDetailsRepository, SaveUserDetailsRepository {

    private final UserRepository userRepository;
    private final UserMappers userMappers;

    public UserAdapter(UserRepository userRepository, UserMappers userMappers) {
        this.userRepository = userRepository;
        this.userMappers = userMappers;
    }


    @Override
    public User findUser(UUID userId) {

        return userRepository.findById(userId)
                .map(userMappers::toDomain)
                .orElseThrow(() -> new UserNotFounException("User not found with id: " + userId));

    }

    @Override
    public void saveUserDetails(User user) {

        try{
            userRepository.save(userMappers.toEntity(user));
        }catch(Exception e){

            throw new UserPersistenceException("Error saving user details for: " + user.getId(), e);

        }

    }
}
