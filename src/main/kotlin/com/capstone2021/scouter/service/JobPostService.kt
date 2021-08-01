package com.capstone2021.scouter.service

import com.capstone2021.scouter.model.Company
import com.capstone2021.scouter.model.JobPosting

interface JobPostService {

    fun saveJobPost(company: Company, jobPost: JobPosting)

    fun updateJobPost(jobPost: JobPosting)

    fun findAll(): List<JobPosting>?

    fun findJobPost(id: Long): JobPosting
}