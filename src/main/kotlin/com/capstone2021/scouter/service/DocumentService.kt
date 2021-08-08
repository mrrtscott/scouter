package com.capstone2021.scouter.service

import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.Documents
import org.springframework.web.multipart.MultipartFile

interface DocumentService {

    fun save(application: Application, document: Documents)
    fun findById(id: Long): Documents
    fun findAllDocuments(): List<Documents>
    fun addDocument(applicantId: Long, applicationId: Long, file: MultipartFile)
}