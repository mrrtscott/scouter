package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.model.Company
import com.capstone2021.scouter.model.JobPosting
import com.capstone2021.scouter.repository.CompanyRepository
import com.capstone2021.scouter.repository.JobPostRepository
import com.capstone2021.scouter.service.JobPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class JobPostServiceImplementation: JobPostService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var jobPostRepository: JobPostRepository


    override fun saveJobPost(company: Company, jobPost: JobPosting) {
        var activeCompany: Company = companyRepository.findById(company.getId()!!).get()
        activeCompany.addJobPosting(jobPost)
        companyRepository.save(activeCompany)
    }

    override fun updateJobPost(jobPost: JobPosting) {
            jobPostRepository.save(jobPost)
    }


    override fun findAll(): List<JobPosting>? {
        return jobPostRepository.findAll()
    }

    override fun findJobPost(id: Long): JobPosting {
        return this.jobPostRepository.getById(id)
    }



}