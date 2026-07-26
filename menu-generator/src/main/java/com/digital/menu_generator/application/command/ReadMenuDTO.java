package com.digital.menu_generator.application.command;

import java.util.UUID;

public record ReadMenuDTO(
        UUID id,
        String name
) {
}
