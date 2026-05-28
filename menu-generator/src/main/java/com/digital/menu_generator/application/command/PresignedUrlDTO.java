package com.digital.menu_generator.application.command;

public record PresignedUrlDTO(
        String presignedUrl,
        String imagePath
) {
}
