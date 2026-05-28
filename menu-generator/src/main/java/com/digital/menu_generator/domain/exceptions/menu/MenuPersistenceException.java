package com.digital.menu_generator.domain.exceptions.menu;

public class MenuPersistenceException extends  RuntimeException{

    public MenuPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
