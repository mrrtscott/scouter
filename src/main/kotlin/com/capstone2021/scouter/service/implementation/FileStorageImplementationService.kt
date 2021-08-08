package com.capstone2021.scouter.service.implementation

import com.amazonaws.AmazonClientException
import com.amazonaws.AmazonServiceException
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.util.IOUtils
import com.capstone2021.scouter.service.FileStorageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.*


@Service
class FileStorageImplementationService : FileStorageService {

    @Autowired
    private var s3: AmazonS3? = null

    private val logger: Logger = LoggerFactory.getLogger(FileStorageImplementationService::class.java)





    override fun save(
        path: String?,
        fileName: String?,
        optionalMetadata: Optional<Map<String?, String?>>,
        inputStream: InputStream?
    ) {
        val metadata = ObjectMetadata()
        optionalMetadata.ifPresent { map ->
            if (map.isNotEmpty()) {
                map.forEach { (key: String?, value: String?) -> metadata.addUserMetadata(key, value) }
            }
        }
        try {
            s3!!.putObject(path, fileName, inputStream, metadata)
        } catch (e: AmazonServiceException) {
            throw IllegalStateException("Failed to store file to s3", e)
        }
    }


//    override fun download(path: String?, key: String?): ByteArray? {
//        return try {
//            val `object`: S3Object = s3!!.getObject(path, key)
//            IOUtils.toByteArray(`object`.objectContent)
//        } catch (e: AmazonServiceException) {
//            throw IllegalStateException("Failed to download file to s3", e)
//        } catch (e: IOException) {
//            throw IllegalStateException("Failed to download file to s3", e)
//        }
//    }


    override fun downloadFile(path:String, keyName: String?): ByteArrayOutputStream? {
        try {
            val s3object: S3Object = s3!!.getObject(GetObjectRequest(path, keyName))
            val `is`: InputStream = s3object.objectContent
            val outputStream = ByteArrayOutputStream()
            var len: Int
            val buffer = ByteArray(4096)
            while (`is`.read(buffer, 0, buffer.size).also { len = it } != -1) {
                outputStream.write(buffer, 0, len)
            }
            return outputStream
        } catch (ioException: IOException) {
            logger.error("IOException: " + ioException.message)
        } catch (serviceException: AmazonServiceException) {
            logger.info("AmazonServiceException Message:    " + serviceException.message)
            throw serviceException
        } catch (clientException: AmazonClientException) {
            logger.info("AmazonClientException Message: " + clientException.message)
            throw clientException
        }
        return null
    }

}