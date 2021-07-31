package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Application
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ApplicantRepository: JpaRepository<Applicant, Long> {






}