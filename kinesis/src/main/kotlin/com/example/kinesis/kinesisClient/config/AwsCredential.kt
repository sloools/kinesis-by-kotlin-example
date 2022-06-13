package com.example.kinesis.kinesisClient.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSCredentialsProviderChain
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.example.kinesis.sdk.config.AwsProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

// NOT USED
//@Configuration
class AwsCredential(
    private val awsProperties: AwsProperties
): AWSCredentialsProvider {

    @Bean
    override fun getCredentials(): AWSCredentials {
        val provider = ProfileCredentialsProvider("local_kinesis")
        return AWSCredentialsProviderChain(provider).credentials
    }

    override fun refresh() {
        TODO("Not yet implemented")
    }

}