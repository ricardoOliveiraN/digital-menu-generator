package com.digital.menu_generator.infrastructure.adapter.storage;

import com.digital.menu_generator.application.port.out.CreatePresignedUrlOut;
import com.digital.menu_generator.domain.exceptions.generics.StorageProviderException;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;

import java.net.URI;
import java.time.Duration;

@Component
public class CreatePresignedUrlAdapter implements AutoCloseable, CreatePresignedUrlOut {

    private final String bucketName = "menu-generator";
    private final Duration expiration = Duration.ofMinutes(15);
    private final S3Presigner presigner;

    public CreatePresignedUrlAdapter(@Value("${cloudflare.r2.account-id}") String accountId,
                                     @Value("${cloudflare.r2.access-key}") String accessKey,
                                     @Value("${cloudflare.r2.secret-key}") String secretKey) {

        String endpoint = String.format("https://%s.r2.cloudflarestorage.com", accountId);
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        this.presigner = S3Presigner.builder()
                .endpointOverride(URI.create(endpoint))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .region(Region.of("auto"))
                .serviceConfiguration(S3Configuration.builder()
                        .pathStyleAccessEnabled(true)
                        .build())
                .build();
    }

    // O metodo agora recebe o 'objectKey' (imagePath) e retorna a URL assinada como String
    public String createPresignedUrl(String objectKey) {

        if (objectKey == null || objectKey.isBlank()) {
            throw new IllegalArgumentException("The objectKey (imagePath) cannot be null or empty");
        }

        try {
            // 1. Criamos a requisição de assinatura para um metodo PUT
            PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                    .signatureDuration(expiration)
                    .putObjectRequest(builder -> builder
                            .bucket(bucketName)
                            .key(objectKey)
                            // Opcional: se quiser restringir o tipo, ex: .contentType("image/jpeg")
                            .build())
                    .build();

            // 2. O S3Presigner gera a requisição pré-assinada
            PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(presignRequest);

            // 3. Extraímos e retornamos a URL gerada em formato String
            return presignedRequest.url().toString();
        }catch (Exception e) {
            throw  new StorageProviderException("Failed to generate presigned URL for key: " + objectKey, e);
        }
    }

    // Boa prática: Fechar o presigner quando o adaptador deixar de existir
    @Override
    @PreDestroy
    public void close() {
        if (presigner != null) {
            presigner.close();
        }
    }
}