package com.digital.menu_generator.application.port.out.menu;

import com.digital.menu_generator.domain.Menu;

import java.util.UUID;

public interface GetMenuRepository {

    Menu findMenuByIdUserAndIdMenu(UUID idUser, UUID idMenu);

}
