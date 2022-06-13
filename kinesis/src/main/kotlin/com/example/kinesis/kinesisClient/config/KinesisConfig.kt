package com.example.kinesis.kinesisClient.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient
import software.amazon.kinesis.common.KinesisClientUtil

@Configuration
class KinesisConfig
{
    @Bean
    fun config(): KinesisAsyncClient{
        val profile = ProfileCredentialsProvider.create("coinfra-krdev")
        return  KinesisClientUtil.createKinesisAsyncClient(
            KinesisAsyncClient.builder()
                .credentialsProvider(profile)
                .region(Region.AP_NORTHEAST_2)
        )
    }
}