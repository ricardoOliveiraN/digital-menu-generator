package com.digital.menu_generator.domain.exceptions.user;

public class UserPersistenceException extends RuntimeException {
    public UserPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
