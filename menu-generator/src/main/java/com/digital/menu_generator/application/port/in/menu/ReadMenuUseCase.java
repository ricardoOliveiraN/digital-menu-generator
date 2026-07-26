package com.digital.menu_generator.application.port.in.menu;

import com.digital.menu_generator.application.command.MenuCommand;
import com.digital.menu_generator.application.command.ReadMenuDTO;

public interface ReadMenuUseCase {

    ReadMenuDTO execute(MenuCommand command);

}
