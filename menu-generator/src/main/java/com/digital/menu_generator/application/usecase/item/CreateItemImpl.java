package com.digital.menu_generator.application.usecase.item;

import com.digital.menu_generator.application.command.CreateItemCommand;
import com.digital.menu_generator.application.port.in.item.CreateItemUseCase;
import com.digital.menu_generator.application.port.out.item.SaveItemRepository;
import com.digital.menu_generator.domain.Item;

public class CreateItemImpl implements CreateItemUseCase {

    private final SaveItemRepository saveItemRepository;

    public CreateItemImpl(SaveItemRepository saveItemRepository) {
        this.saveItemRepository = saveItemRepository;
    }


    @Override
    public void execute(CreateItemCommand command) {

        Item item = new Item(
                null,
                command.idMenu(),
                command.nomeItem(),
                command.descricaoItem(),
                command.precoItem(),
                command.imagePath(),
                command.posicaoTela()
        );

        saveItemRepository.saveItem(item);

    }
}
