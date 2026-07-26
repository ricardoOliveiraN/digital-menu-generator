package com.digital.menu_generator.application.port.out.item;

import java.util.UUID;

public interface DeleteItemRepository {

    void deleteItem(UUID idItem, UUID idMenu);

}
