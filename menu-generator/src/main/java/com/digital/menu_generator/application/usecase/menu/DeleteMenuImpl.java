package com.digital.menu_generator.application.usecase.menu;

import com.digital.menu_generator.application.command.MenuCommand;
import com.digital.menu_generator.application.port.in.menu.DeleteMenuUseCase;
import com.digital.menu_generator.application.port.out.menu.DeleteMenuRepository;
import com.digital.menu_generator.domain.exceptions.generics.InvalidAttributesException;

public class DeleteMenuImpl implements DeleteMenuUseCase {

    private final DeleteMenuRepository deleteMenuRepository;

    public DeleteMenuImpl(DeleteMenuRepository deleteMenuRepository) {
        this.deleteMenuRepository = deleteMenuRepository;
    }


    @Override
    public void execute(MenuCommand command) {
        deleteMenuRepository.deleteMenu(command.idMenu(), command.idUser());
    }
}
