package com.digital.menu_generator.application.port.in.item;

import com.digital.menu_generator.application.command.ItemCommand;

import java.util.UUID;

public interface DeleteItemUseCase {

    void deleteItem(ItemCommand command);

}
