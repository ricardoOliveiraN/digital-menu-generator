package com.digital.menu_generator.domain;

import java.util.UUID;

public class Menu {

    private UUID id;
    private UUID idUser;
    private String nomeMenu;

    public Menu(UUID id, UUID idUser, String nomeMenu) {
        this.id = id;
        this.idUser = idUser;
        this.nomeMenu = nomeMenu;
    }
}
