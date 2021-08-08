package com.capstone2021.scouter.service

import com.capstone2021.scouter.model.Enquiry

interface EnquiryService {

    fun save(applicationId: Long,enquiry: Enquiry)

}