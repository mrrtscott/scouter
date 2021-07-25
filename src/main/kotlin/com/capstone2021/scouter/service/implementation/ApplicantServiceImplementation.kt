package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.repository.ApplicantRepository
import com.capstone2021.scouter.service.ApplicantService
import org.springframework.beans.factory.annotation.Autowired

class ApplicantServiceImplementation : ApplicantService {

    @Autowired
    lateinit var applicantRepository: ApplicantRepository

    override fun saveApplicant(applicant: Applicant) {
        applicantRepository.save(applicant)
    }

    override fun findAllApplicants(): List<Applicant>? {
        return applicantRepository.findAll()
    }

    override fun findApplicant(id: Long): Applicant? {
        return applicantRepository.getById(id)
    }

    override fun countApplicant(): Long {
        return applicantRepository.count()
    }
}