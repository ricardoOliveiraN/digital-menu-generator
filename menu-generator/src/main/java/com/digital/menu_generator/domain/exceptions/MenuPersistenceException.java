package com.digital.menu_generator.domain.exceptions;

public class MenuPersistenceException extends  RuntimeException{

    public MenuPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
