package com.digital.menu_generator.application.port.in;

import com.digital.menu_generator.application.command.CreateItemCommand;

public interface CreateItemUseCase {

    void execute(CreateItemCommand command);

}
