package com.digital.menu_generator.domain.exceptions;

import java.util.UUID;

public class MenuCreationLimitExceedException extends RuntimeException{

    public MenuCreationLimitExceedException(String name, UUID idUser) {
        super(String.format("User %s, with id %s, has reached the limit of menu creation (3)", name, idUser));
    }

}
