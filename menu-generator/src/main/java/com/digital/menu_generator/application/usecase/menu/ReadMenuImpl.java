package com.digital.menu_generator.application.usecase.menu;

import com.digital.menu_generator.application.command.MenuCommand;
import com.digital.menu_generator.application.command.ReadMenuDTO;
import com.digital.menu_generator.application.port.in.menu.ReadMenuUseCase;
import com.digital.menu_generator.application.port.out.menu.ReadMenuRepository;
import com.digital.menu_generator.domain.Menu;

public class ReadMenuImpl implements ReadMenuUseCase {

    private final ReadMenuRepository readMenuRepository;

    public ReadMenuImpl(ReadMenuRepository readMenuRepository) {
        this.readMenuRepository = readMenuRepository;
    }

    @Override
    public ReadMenuDTO execute(MenuCommand command) {

        Menu menu = readMenuRepository.readMenu(command.idMenu(), command.idUser());

        return mapToReadMenuDTO(menu);

    }

    private ReadMenuDTO mapToReadMenuDTO(Menu menu) {

        return new ReadMenuDTO(
            menu.getId(),
            menu.getNomeMenu()
        );

    }

}
