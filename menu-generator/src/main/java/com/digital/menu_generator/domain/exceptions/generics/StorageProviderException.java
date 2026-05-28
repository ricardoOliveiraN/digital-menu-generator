package com.digital.menu_generator.domain.exceptions.generics;

public class StorageProviderException extends RuntimeException {
    public StorageProviderException(String message, Throwable cause) {
        super(message, cause);
    }
}
