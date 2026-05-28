package com.digital.menu_generator.infrastructure.entrypoint.exceptions;


import com.digital.menu_generator.domain.exceptions.generics.InvalidAttributesException;
import com.digital.menu_generator.domain.exceptions.generics.StorageProviderException;
import com.digital.menu_generator.domain.exceptions.menu.MenuCreationLimitExceedException;
import com.digital.menu_generator.domain.exceptions.menu.MenuPersistenceException;
import com.digital.menu_generator.domain.exceptions.user.UserNotFounException;
import com.digital.menu_generator.domain.exceptions.user.UserPersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UserNotFounException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFounException ex) {
        log.error("[ERROR - Token]: user need exists, but: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: user with no authorization to create menu");
    }

    @ExceptionHandler(MenuCreationLimitExceedException.class)
    public ResponseEntity<String> handleMenuCreationLimitExceedException(MenuCreationLimitExceedException ex) {
        log.warn("[WARN - Business Rule]: user has exceeded the menu creation limit, but: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("User has exceeded the menu creation limit (3)");
    }

    @ExceptionHandler(MenuPersistenceException.class)
    public ResponseEntity<String > handleMenuPersistenceException(MenuPersistenceException ex) {
        log.error("[ERROR - Persistence]: failed to persist menu: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save menu to the database");
    }

    @ExceptionHandler(UserPersistenceException.class)
    public ResponseEntity<String > handleUserPersistenceException(UserPersistenceException ex) {
        log.error("[ERROR - Persistence]: failed to persist user: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save user to the database");
    }

    @ExceptionHandler(InvalidAttributesException.class)
    public ResponseEntity<String> handleInvalidAttributesException(InvalidAttributesException ex) {
        log.warn("[WARN - Validation]: invalid attributes provided for item creation, but: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid attributes provided for item creation");
    }

    @ExceptionHandler(StorageProviderException.class)
    public ResponseEntity<String> handleStorageProviderException(StorageProviderException ex) {
        log.error("[ERROR - Storage Provider]: failed to interact with storage provider, but: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to interact with storage provider");
    }

}
