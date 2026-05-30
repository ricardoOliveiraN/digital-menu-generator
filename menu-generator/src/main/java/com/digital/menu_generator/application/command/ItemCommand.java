package com.digital.menu_generator.application.command;

import java.util.UUID;

public record ItemCommand(
        UUID id,
        UUID idMenu,
        UUID idUser
) {

    public ItemCommand{

        if(id == null){
            throw new IllegalArgumentException("Item ID cannot be null.");
        }
        if(idMenu == null) {
            throw new IllegalArgumentException("Menu ID cannot be null.");
        }
        if(idUser == null) {
            throw new IllegalArgumentException("User ID cannot be null.");
        }
    }

}
