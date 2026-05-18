package com.digital.menu_generator.infrastructure.adapter.database.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false, name = "phone_number")
    private String telefone;
    @Column(name = "menu_count")
    private Integer quantidadeMenus;
    @Column(name = "logo_url")
    private String urlLogoStorage;
    @Column(name = "brand_name")
    private String nomeMarca;

    public UserEntity(String name, UUID id, String email, String telefone, Integer quantidadeMenus, String urlLogoStorage, String nomeMarca) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.telefone = telefone;
        this.quantidadeMenus = quantidadeMenus;
        this.urlLogoStorage = urlLogoStorage;
        this.nomeMarca = nomeMarca;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getQuantidadeMenus() {
        return quantidadeMenus;
    }

    public void setQuantidadeMenus(Integer quantidadeMenus) {
        this.quantidadeMenus = quantidadeMenus;
    }

    public String getUrlLogoStorage() {
        return urlLogoStorage;
    }

    public void setUrlLogoStorage(String urlLogoStorage) {
        this.urlLogoStorage = urlLogoStorage;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
}
