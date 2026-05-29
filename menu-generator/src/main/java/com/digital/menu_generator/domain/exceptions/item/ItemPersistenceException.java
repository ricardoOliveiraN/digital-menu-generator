package com.digital.menu_generator.domain.exceptions.item;

public class ItemPersistenceException extends RuntimeException {
    public ItemPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
