package com.digital.menu_generator.application.command;

import java.util.UUID;

public record MenuCommand(
        UUID idMenu,
        UUID idUser
) {

    public MenuCommand {
        if (idMenu == null) {
            throw new IllegalArgumentException("Menu ID cannot be null.");
        }
        if (idUser == null) {
            throw new IllegalArgumentException("User ID cannot be null.");
        }
    }

}
