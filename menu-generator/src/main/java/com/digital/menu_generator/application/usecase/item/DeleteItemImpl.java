package com.digital.menu_generator.application.usecase.item;

import com.digital.menu_generator.application.command.ItemCommand;
import com.digital.menu_generator.application.command.MenuCommand;
import com.digital.menu_generator.application.command.ReadMenuDTO;
import com.digital.menu_generator.application.port.in.item.DeleteItemUseCase;
import com.digital.menu_generator.application.port.in.menu.ReadMenuUseCase;
import com.digital.menu_generator.application.port.out.item.DeleteItemRepository;


public class DeleteItemImpl implements DeleteItemUseCase {

    private final ReadMenuUseCase menu;
    private final DeleteItemRepository deleteItemRepository;

    public DeleteItemImpl(ReadMenuUseCase menu, DeleteItemRepository deleteItemRepository) {
        this.menu = menu;
        this.deleteItemRepository = deleteItemRepository;
    }

    @Override
    public void deleteItem(ItemCommand command) {
        ReadMenuDTO menuSearched = menu.execute(new MenuCommand(command.idMenu(), command.idUser()));
        deleteItemRepository.deleteItem(command.id(), menuSearched.id());
    }


}
