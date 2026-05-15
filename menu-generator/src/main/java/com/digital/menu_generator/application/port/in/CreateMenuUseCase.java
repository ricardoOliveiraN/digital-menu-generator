package com.digital.menu_generator.application.port.in;

import com.digital.menu_generator.application.command.CreateMenuCommand;

public interface CreateMenuUseCase {
    void execute(CreateMenuCommand command);
}
