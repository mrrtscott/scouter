package com.capstone2021.scouter.service.implementation

import com.amazonaws.AmazonServiceException
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.util.IOUtils
import com.capstone2021.scouter.service.FileStorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.IOException
import java.io.InputStream
import java.util.*


@Service
class FileStorageImplementationService : FileStorageService {

    @Autowired
    private var s3: AmazonS3? = null



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


    override fun download(path: String?, key: String?): ByteArray? {
        return try {
            val `object`: S3Object = s3!!.getObject(path, key)
            IOUtils.toByteArray(`object`.objectContent)
        } catch (e: AmazonServiceException) {
            throw IllegalStateException("Failed to download file to s3", e)
        } catch (e: IOException) {
            throw IllegalStateException("Failed to download file to s3", e)
        }
    }

}