package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.Applicant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ApplicantRepository: JpaRepository<Applicant, Long> {

}