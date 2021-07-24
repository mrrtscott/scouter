package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transaction
import javax.transaction.Transactional

@Repository
interface CompanyRepository :JpaRepository<Company, Long> {



}