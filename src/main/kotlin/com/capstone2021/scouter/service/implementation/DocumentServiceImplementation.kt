package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.algorithms.Functions
import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.Documents
import com.capstone2021.scouter.model.enum.BucketName
import com.capstone2021.scouter.repository.ApplicantRepository
import com.capstone2021.scouter.repository.ApplicationRepository
import com.capstone2021.scouter.repository.DocumentRepository
import com.capstone2021.scouter.service.DocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*

@Service
class DocumentServiceImplementation : DocumentService {

    @Autowired
    lateinit var documentRepository: DocumentRepository

    @Autowired
    lateinit var applicationRepository: ApplicationRepository

    @Autowired
    lateinit var applicantRepository: ApplicantRepository

    @Autowired
    lateinit var fileStorage: FileStorageImplementationService


    override fun save(application: Application,document: Documents) {
        var activeApplication = application.getId()?.let { applicationRepository.getById(it) }
        activeApplication!!.addDocuments(document)
        applicationRepository.save(activeApplication)
    }

    override fun findById(id: Long): Documents {
        return documentRepository.getById(id)
    }

    override fun findAllDocuments(): List<Documents> {
        return this.documentRepository.findAll()
    }

    override fun addDocument(applicantId: Long, applicationId: Long, file: MultipartFile) {
        var functions = Functions()
        var activeApplicant = applicantRepository.getById(applicantId)
        var metadata: Map<String?, String?> = functions.extractMetadata(file)
        var path = java.lang.String.format("%s/%s", BucketName.DOCUMENTS_AWS.bucketName, activeApplicant.getId())
        val filename = java.lang.String.format("%s-%s", UUID.randomUUID(), file.originalFilename)


        var document = Documents(file.originalFilename.toString(), path,filename)
        var application = applicationRepository.getById(applicationId)

        application.addDocuments(document)


        try {
            fileStorage.save(path, filename, Optional.of(metadata), file.inputStream)
            applicationRepository.save(application)
        } catch (e: IOException) {
            throw IllegalStateException(e)
        }



    }
}