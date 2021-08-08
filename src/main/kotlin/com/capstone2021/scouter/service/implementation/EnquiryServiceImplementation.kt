package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.model.Enquiry
import com.capstone2021.scouter.repository.ApplicationRepository
import com.capstone2021.scouter.repository.EnquiryRepository
import com.capstone2021.scouter.service.EnquiryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EnquiryServiceImplementation:EnquiryService {



    lateinit var applicationRepository: ApplicationRepository

    override fun save(applicationId: Long,enquiry: Enquiry) {
        var activeApplication = applicationRepository.getById(applicationId)
        activeApplication.addEnquiry(enquiry)
        applicationRepository.save(activeApplication)


    }
}