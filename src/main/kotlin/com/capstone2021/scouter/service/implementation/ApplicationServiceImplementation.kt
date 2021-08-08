package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.JobPosting
import com.capstone2021.scouter.repository.ApplicantRepository
import com.capstone2021.scouter.repository.ApplicationRepository
import com.capstone2021.scouter.service.ApplicationService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ApplicationServiceImplementation: ApplicationService {

    lateinit var applicantRepository: ApplicantRepository

    lateinit var applicationRepository: ApplicationRepository

    override fun saveApplication(applicant: Applicant, jobPosting: JobPosting) {
        lateinit var application:Application
        application!!.setApplicant(applicant)
        application!!.setJob(jobPosting)
        applicationRepository.save(application)
    }

    override fun save(application: Application) {
        applicationRepository.save(application)
    }

    override fun findAllApplications(): List<Application> {
        return this.applicationRepository.findAll()
    }

    override fun findApplicationsPerApplicant(applicantId: Long): List<Application> {
        return this.applicationRepository.getApplicationsForApplicant(applicantId)
    }

    override fun findApplicationPerApplicant(job: Long, status: Any): List<Any> {
       return this.applicationRepository.getApplicantsPerJob(job, status)
    }

    override fun findApplicationAll(job: Long): List<Any> {
        return this.applicationRepository.getApplicantsPerJobAll(job)
    }

    override fun findApplication(id: Long): Application? {
        return this.applicationRepository.getById(id)
    }


}