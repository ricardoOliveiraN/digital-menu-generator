package com.digital.menu_generator.domain;

import com.digital.menu_generator.domain.exceptions.menu.MenuCreationLimitExceedException;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String telefone;
    private Integer quantidadeMenus;
    private String urlLogoStorage;
    private String urlWhatsapp;
    private String nomeMarca;

    public User(UUID id, String name, String email, String telefone, Integer quantidadeMenus, String urlLogoStorage, String nomeMarca, String urlWhatsapp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.quantidadeMenus = quantidadeMenus;
        this.urlLogoStorage = urlLogoStorage;
        this.nomeMarca = nomeMarca;
        this.urlWhatsapp = urlWhatsapp;
    }

    public boolean canCreateMenu() {
        return quantidadeMenus < 3;
    }

    public Menu createMenu(String nomeMenu){
        if(!canCreateMenu()){
            throw new MenuCreationLimitExceedException(this.name, this.id);
        }

        this.quantidadeMenus++;

        return new Menu(null, this.id, nomeMenu);
    }

    public boolean isFirstLogin(){
        return email == null || email.isEmpty();
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Integer getQuantidadeMenus() {
        return quantidadeMenus;
    }

    public String getUrlLogoStorage() {
        return urlLogoStorage;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public String getUrlWhatsapp() {
        return urlWhatsapp;
    }
}
