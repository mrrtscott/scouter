package com.capstone2021.scouter.service

import com.capstone2021.scouter.model.Applicant

interface ApplicantService {

    fun saveApplicant(applicant: Applicant)

    fun findAllApplicants(): List<Applicant>?

    fun findApplicant(id: Long): Applicant?

    fun countApplicant(): Long

}