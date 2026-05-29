package com.digital.menu_generator.application.command;

import java.util.UUID;

public record DeleteMenuCommand(
        UUID idMenu,
        UUID idUser
) {
}
