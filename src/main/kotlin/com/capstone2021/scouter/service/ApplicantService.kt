package com.capstone2021.scouter.service

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.ApplicantRadar
import com.capstone2021.scouter.model.CompanyJobPosting
import com.capstone2021.scouter.model.JobPosting

interface ApplicantService {

    fun saveApplicant(applicant: Applicant)

    fun findAllApplicants(): List<Applicant>?

    fun findApplicant(id: Long): Applicant?

    fun countApplicant(): Long

    fun getTwoApplicant(applicant1: Long, applicant2: Long): List<Applicant>?

    fun getQualifiedJobs(applicant: Applicant):MutableList<CompanyJobPosting>?

    fun getTwoApplicantsWithJob(applicant1: Long, applicant2: Long, job:Long): MutableList<ApplicantRadar>



}