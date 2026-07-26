package com.digital.menu_generator.domain.exceptions.item;

public class ItemConflictException extends RuntimeException {
    public ItemConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
