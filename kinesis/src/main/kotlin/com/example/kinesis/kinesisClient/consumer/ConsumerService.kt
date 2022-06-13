package com.example.kinesis.kinesisClient.consumer

import org.springframework.stereotype.Service
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorResponse

//@Service
class ConsumerService(
    private val kinesisClient: KinesisAsyncClient
) {

    // NOT WORKING
    fun consume(streamName: String, shardId: String){
        val getShardIteratorRequest =
            GetShardIteratorRequest.builder()
                .streamName(streamName)
                .shardId(shardId)
                .shardIteratorType("LATEST")
                .build()

        val shardIterator = kinesisClient.getShardIterator(getShardIteratorRequest)
            .get().shardIterator()

        val getRecordsRequest = GetRecordsRequest.builder()
            .shardIterator(shardIterator)
            .build()

        val getRecord = kinesisClient.getRecords(
            getRecordsRequest
        ).get().records().map {
            val data = it.data()
            println(data)
        }
    }

}