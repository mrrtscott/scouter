package com.capstone2021.scouter.service

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.JobPosting

interface ApplicationService {

    fun saveApplication(applicant: Applicant, jobPosting: JobPosting)

    fun findAllApplications(): List<Application>

    fun findApplicationsPerApplicant(applicantId: Long):List<Application>
}