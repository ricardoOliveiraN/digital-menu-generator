package com.digital.menu_generator.application.port.out.menu;

import java.util.UUID;

public interface DeleteMenuRepository {

    void deleteMenu(UUID idMenu, UUID idUser);

}
