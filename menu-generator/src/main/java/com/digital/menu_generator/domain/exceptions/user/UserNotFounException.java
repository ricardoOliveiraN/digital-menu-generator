package com.digital.menu_generator.domain.exceptions.user;

public class UserNotFounException extends RuntimeException{

    public UserNotFounException(String message) {
        super(message);
    }

}
