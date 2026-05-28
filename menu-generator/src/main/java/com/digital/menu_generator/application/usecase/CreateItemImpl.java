package com.digital.menu_generator.application.usecase;

import com.digital.menu_generator.application.command.CreateItemCommand;
import com.digital.menu_generator.application.port.in.CreateItemUseCase;
import com.digital.menu_generator.application.port.out.item.SaveItemRepository;

public class CreateItemImpl implements CreateItemUseCase {

    private final SaveItemRepository saveItemRepository;

    public CreateItemImpl(SaveItemRepository saveItemRepository) {
        this.saveItemRepository = saveItemRepository;
    }


    @Override
    public void execute(CreateItemCommand command) {

    }
}
