package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transaction
import javax.transaction.Transactional

@Repository
interface CompanyRepository :JpaRepository<Company, Long> {

    @Query(value = "SELECT * FROM company WHERE companyid IN (SELECT company_id FROM company_job_posting WHERE job_post_id = ?1)", nativeQuery = true)
    fun getCompanyByJobPostId(jobPostId: Long): Company?



}