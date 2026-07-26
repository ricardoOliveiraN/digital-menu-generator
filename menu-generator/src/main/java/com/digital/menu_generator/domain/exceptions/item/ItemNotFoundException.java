package com.digital.menu_generator.domain.exceptions.item;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
