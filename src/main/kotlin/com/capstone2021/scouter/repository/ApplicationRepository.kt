package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.ApplicationId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ApplicationRepository: JpaRepository<Application, Long> {

    @Query(value = "SELECT a  FROM Application a WHERE a.applicant.id = ?1")
    fun getApplicationsForApplicant(applicantId: Long):List<Application>


    @Query(value = "SELECT applicant.id FROM applicant WHERE applicant.id IN(SELECT applicant.id FROM application WHERE application.job_post_id = :jobPostId AND application.status = :status)",nativeQuery = true)
    fun getApplicantsPerJob(jobPostId: Long, status:Any):List<Long>

    @Query(value = "SELECT applicant.id FROM applicant WHERE applicant.id IN(SELECT applicant.id FROM application WHERE application.job_post_id = :jobPostId)",nativeQuery = true)
    fun getApplicantsPerJobAll(jobPostId: Long):List<Long>


//    @Query(value = "SELECT a FROM Applicant a INNER JOIN Application ap WHERE ap.job.id = ?1 AND ap.status = ?2")
//    fun getApplicantsPerJobAll(jobPostId: Long): List<Applicant>
//
//
//    @Query(value = "SELECT a FROM Applicant a INNER JOIN Application ap WHERE ap.job.id = ?1")
//    fun getApplicantsPerJob(jobPostId: Long, status:Any): List<Applicant>
}