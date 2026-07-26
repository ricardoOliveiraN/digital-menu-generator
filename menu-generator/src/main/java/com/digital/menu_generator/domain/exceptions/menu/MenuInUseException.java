package com.digital.menu_generator.domain.exceptions.menu;

public class MenuInUseException extends RuntimeException {
    public MenuInUseException(String message, Throwable cause) {
        super(message, cause);
    }
}
