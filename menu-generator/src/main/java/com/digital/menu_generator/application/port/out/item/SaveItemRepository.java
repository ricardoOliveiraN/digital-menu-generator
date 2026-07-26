package com.digital.menu_generator.application.port.out.item;

import com.digital.menu_generator.domain.Item;

public interface SaveItemRepository {

    void saveItem(Item item);

}
