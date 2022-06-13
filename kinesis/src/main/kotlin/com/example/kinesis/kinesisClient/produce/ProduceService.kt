package com.example.kinesis.kinesisClient.produce

import com.example.kinesis.kinesisClient.config.KinesisConfig
import com.example.kinesis.kinesisClient.config.exception.MyException
import com.example.kinesis.kinesisClient.model.SampleRecord
import org.springframework.stereotype.Service
import software.amazon.awssdk.core.SdkBytes
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest
import software.amazon.awssdk.services.kinesis.model.PutRecordResponse
import java.util.concurrent.ExecutionException

@Service
class ProduceService(
    private val kinesisClient: KinesisAsyncClient,
    private val kinesisConfig: KinesisConfig
) {
    fun send(record: SampleRecord, shardName: String, streamName: String): PutRecordResponse {
        try {
            val byte = record.toJsonAsByte()
            return kinesisConfig.config().putRecord(
                PutRecordRequest.builder()
                    .streamName(streamName)
                    .partitionKey(shardName)
                    .data(SdkBytes.fromByteArray(byte))
                    .build()
            ).get()

        }catch (e: InterruptedException) {
            System.out.println("Interrupted, assuming shutdown.");
        } catch (e: ExecutionException) {
            System.err.println("Exception while sending data to Kinesis will try again next cycle");
        }

//        return PutRecordResponse()
        throw MyException("Error Occured While Sending Record To Kinesis")
    }

}