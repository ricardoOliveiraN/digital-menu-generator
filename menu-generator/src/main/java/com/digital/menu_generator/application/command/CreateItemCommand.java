package com.digital.menu_generator.application.command;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateItemCommand (

        UUID idMenu,
        String nomeItem,
        String descricaoItem,
        BigDecimal precoItem,
        String imagePath,
        Integer posicaoTela

){
}
