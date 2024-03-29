package com.smu.smuenip;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.findify.s3mock.S3Mock;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@TestConfiguration
public class S3MockConfig {

    @Bean(name = "s3Mock")
    public S3Mock s3Mock() {
        return new S3Mock.Builder().withPort(8002).withInMemoryBackend().build();
    }

    @Profile("test")
    @Primary
    @Bean(name = "amazonS3", destroyMethod = "shutdown")
    public AmazonS3 amazonS3() {
        AwsClientBuilder.EndpointConfiguration endpoint = new EndpointConfiguration(
            "http://localhost:8002", "ap-northeast-2");

        AmazonS3 client = AmazonS3ClientBuilder
            .standard()
            .withPathStyleAccessEnabled(true)
            .withEndpointConfiguration(endpoint)
            .withCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()))
            .build();

        return client;
    }
}
