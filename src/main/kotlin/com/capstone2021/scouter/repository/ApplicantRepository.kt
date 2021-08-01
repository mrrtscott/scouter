package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Application
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ApplicantRepository: JpaRepository<Applicant, Long> {

    @Query(value = "SELECT a FROM Applicant a WHERE a.id = ?1 OR a.id = ?2")
    fun getSpecificApplicants(applicant1: Long, applicant2: Long): List<Applicant>






}