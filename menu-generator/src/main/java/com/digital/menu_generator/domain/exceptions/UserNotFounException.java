package com.digital.menu_generator.domain.exceptions;

public class UserNotFounException extends RuntimeException{

    public UserNotFounException(String message) {
        super(message);
    }

}
