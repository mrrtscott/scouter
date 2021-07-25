package com.capstone2021.scouter.service

import com.capstone2021.scouter.model.Company
import org.springframework.stereotype.Service


interface CompanyService {

    fun saveCompany (company: Company)

    fun findAllCompany():List<Company>

    fun findCompany(id: Long): Company

    fun countCompany(): Long


}