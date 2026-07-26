package com.digital.menu_generator.application.port.in.item;

import com.digital.menu_generator.application.command.CreateItemCommand;

public interface CreateItemUseCase {

    void execute(CreateItemCommand command);

}
