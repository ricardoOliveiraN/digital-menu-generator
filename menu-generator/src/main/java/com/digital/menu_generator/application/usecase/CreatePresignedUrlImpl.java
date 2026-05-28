package com.digital.menu_generator.application.usecase;

import com.digital.menu_generator.application.command.PresignedUrlDTO;
import com.digital.menu_generator.application.port.in.CreatePresignedUrlUseCase;
import com.digital.menu_generator.application.port.out.CreatePresignedUrlOut;
import com.digital.menu_generator.domain.Item;

import java.util.UUID;

public class CreatePresignedUrlImpl implements CreatePresignedUrlUseCase {

    private final CreatePresignedUrlOut presigned;

    public CreatePresignedUrlImpl(CreatePresignedUrlOut presigned) {
        this.presigned = presigned;
    }


    @Override
    public PresignedUrlDTO execute(UUID idMenu) {

        String imagePath = Item.gerarPathImagem(idMenu);
        String presignedUrl = presigned.createPresignedUrl(imagePath);

        return new PresignedUrlDTO(presignedUrl, imagePath);
    }
}
