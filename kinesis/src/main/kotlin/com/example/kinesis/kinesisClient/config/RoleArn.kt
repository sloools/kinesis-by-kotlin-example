package com.example.kinesis.kinesisClient.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sts.StsClient
import software.amazon.awssdk.services.sts.auth.StsAssumeRoleCredentialsProvider
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest

@Configuration
class RoleArn() {
    val roleArn = 

//    val stsClient = StsClient.builder()
//        .region(Region.AP_NORTHEAST_2)
//        .build()
//
//    val roleRequest = AssumeRoleRequest.builder()
//        .roleArn(roleArn)
//        .roleSessionName("KINESIS-DEV")
//        .build()
//
//    val roleCredentialsProvider = StsAssumeRoleCredentialsProvider.builder()
//        .stsClient(stsClient)
//        .refreshRequest(roleRequest)
//        .build()
//
//    fun getRoleProvider(): StsAssumeRoleCredentialsProvider? {
//        return roleCredentialsProvider
//    }

    fun getStsClient(): StsClient? {
        val region = Region.AP_NORTHEAST_2

        return StsClient.builder()
            .region(region)
            .build()
    }
    fun getRoleRequest(): AssumeRoleRequest? {
        return AssumeRoleRequest.builder()
            .roleArn(roleArn)
            .roleSessionName("KINESIS-DEV")
            .build()
    }
    @Bean
    fun getRoleProvider(): StsAssumeRoleCredentialsProvider? {
        return StsAssumeRoleCredentialsProvider.builder()
            .stsClient(getStsClient())
            .refreshRequest(getRoleRequest())
            .build()
    }
}
