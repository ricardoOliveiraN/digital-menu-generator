package com.digital.menu_generator.infrastructure.adapter.database.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "menus")
@Entity
public class MenuEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private UserEntity user;

    private String name;

    public MenuEntity(String name, UserEntity user) {
        this.user = user;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
