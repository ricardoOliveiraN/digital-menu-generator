package com.digital.menu_generator.application.command;

import java.util.UUID;

public record CreateMenuCommand(
        UUID idUser,
        String name
) {
}
