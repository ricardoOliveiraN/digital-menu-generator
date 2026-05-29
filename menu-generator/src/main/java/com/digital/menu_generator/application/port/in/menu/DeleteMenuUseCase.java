package com.digital.menu_generator.application.port.in.menu;


import com.digital.menu_generator.application.command.DeleteMenuCommand;

public interface DeleteMenuUseCase {

    void execute (DeleteMenuCommand command);


}
