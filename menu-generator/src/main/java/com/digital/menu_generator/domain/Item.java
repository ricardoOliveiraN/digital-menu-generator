package com.digital.menu_generator.domain;

import com.digital.menu_generator.domain.exceptions.generics.InvalidAttributesException;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {

    private UUID id;
    private UUID idMenu;
    private String nomeItem;
    private String descricaoItem;
    private BigDecimal precoItem;
    private String imagePath;
    private Integer posicaoTela;

    public Item(UUID id, UUID idMenu, String nomeItem, String descricaoItem, BigDecimal precoItem, String imagePath, Integer posicaoTela) {

        if(idMenu == null) throw new InvalidAttributesException("idMenu cannot be null");
        if(nomeItem == null || nomeItem.isBlank()) throw new InvalidAttributesException("nomeItem cannot be null or blank");
        if(descricaoItem == null || descricaoItem.isBlank()) throw new InvalidAttributesException("descricaoItem cannot be null or blank");
        if(precoItem == null || precoItem.compareTo(BigDecimal.ZERO) < 0) throw new InvalidAttributesException("precoItem cannot be null or negative");
        if(imagePath == null || imagePath.isBlank()) throw new InvalidAttributesException("imagePath cannot be null or blank");
        if(posicaoTela == null || posicaoTela < 0) throw new InvalidAttributesException("posicaoTela cannot be null or negative");


        this.id = id;
        this.idMenu = idMenu;
        this.nomeItem = nomeItem;
        this.descricaoItem = descricaoItem;
        this.precoItem = precoItem;
        this.imagePath = imagePath;

        this.posicaoTela = posicaoTela;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdMenu() {
        return idMenu;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }


    public BigDecimal getPrecoItem() {
        return precoItem;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Integer getPosicaoTela() {
        return posicaoTela;
    }


    public static String gerarPathImagem(UUID idMenuNew){

        if (idMenuNew == null) {
            throw new InvalidAttributesException("idMenu cannot be null to generate image path");
        }

        long timestamp = System.currentTimeMillis();
        String idUnico = UUID.randomUUID().toString();
        return "images/" + idMenuNew + "/" + timestamp + "-" + idUnico + ".jpg";
    }


}
