package com.digital.menu_generator.application.port.in;

import com.digital.menu_generator.application.command.PresignedUrlDTO;

import java.util.UUID;

public interface CreatePresignedUrlUseCase {

    PresignedUrlDTO execute(UUID idMenu);

}
