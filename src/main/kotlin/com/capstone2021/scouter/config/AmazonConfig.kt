package com.capstone2021.scouter.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * This class is responsible for the Amazon S3 Bucket Services
 * @return AmazonS3ClientBuilder
 */
@Configuration
class AmazonConfig {
    @Bean
    fun s3(): AmazonS3? {
        val awsCredentials: AWSCredentials = BasicAWSCredentials(
            "AKIA2U7HFK3UEEWHISXI",
            "D9bsUazZmsT2x0Lk5QbaDL+rjl8sce7bjNgpUAY1"
        )
        return AmazonS3ClientBuilder
            .standard()
            .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
            .build()
    }
}