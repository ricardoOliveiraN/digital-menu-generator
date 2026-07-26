package com.digital.menu_generator.domain.exceptions.menu;

public class MenuNotFoundExcepetion extends RuntimeException {
    public MenuNotFoundExcepetion(String message) {
        super(message);
    }
}
