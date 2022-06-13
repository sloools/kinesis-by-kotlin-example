package com.example.kinesis.kinesisClient

import com.example.kinesis.kinesisClient.consumer.ConsumerService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ConsumeRecordTest @Autowired constructor(
    val consumeService: ConsumerService
){

    @Test
    fun consumeTest(){
        consumeService.consume("local_kinesis_test", "shard_1")
    }
}