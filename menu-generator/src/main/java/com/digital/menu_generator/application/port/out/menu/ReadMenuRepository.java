package com.digital.menu_generator.application.port.out.menu;

import com.digital.menu_generator.domain.Menu;

import java.util.UUID;

public interface ReadMenuRepository {

    Menu readMenu(UUID idMenu, UUID idUser);

}
