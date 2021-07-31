package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.ApplicationId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ApplicationRepository: JpaRepository<Application, Long> {

    @Query(value = "SELECT a  FROM Application a WHERE a.applicant.id = ?1")
    fun getApplicationsForApplicant(applicantId: Long):List<Application>
}