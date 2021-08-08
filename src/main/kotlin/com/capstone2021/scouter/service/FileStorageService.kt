package com.capstone2021.scouter.service

import com.amazonaws.AmazonServiceException
import com.amazonaws.services.s3.model.ObjectMetadata
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*


interface FileStorageService {

    //fun download(path: String?, key: String?): ByteArray?
    fun save(
        path: String?,
        fileName: String?,
        optionalMetadata: Optional<Map<String?, String?>>,
        inputStream: InputStream?
    )

    fun downloadFile(path:String, keyName: String?): ByteArrayOutputStream?

}