package com.capstone2021.scouter.service

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.JobPosting

interface ApplicationService {

    fun saveApplication(applicant: Applicant, jobPosting: JobPosting)

    fun findAllApplications(): List<Application>

    fun findApplicationsPerApplicant(applicantId: Long):List<Application>

    fun findApplicationPerApplicant(job: Long, status: Any): List<Any>

    fun findApplicationAll(job:Long):List<Any>

    fun findApplication(id: Long):Application?
}