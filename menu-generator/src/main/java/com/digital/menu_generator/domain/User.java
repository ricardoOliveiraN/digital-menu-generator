package com.digital.menu_generator.domain;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String telefone;
    private Integer quantidadeMenus;
    private String urlLogoStorage;
    private String nomeMarca;

    public User(UUID id, String name, String email, String telefone, Integer quantidadeMenus, String urlLogoStorage, String nomeMarca) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.quantidadeMenus = quantidadeMenus;
        this.urlLogoStorage = urlLogoStorage;
        this.nomeMarca = nomeMarca;
    }

    public Boolean canCreateMenu() {
        return quantidadeMenus < 3;
    }

    public Boolean isFirstLogin(){
        return email == null || email.isEmpty();
    }

    public void incrementMenuCount() {
        this.quantidadeMenus += 1;
    }

}
