package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.model.Company
import com.capstone2021.scouter.repository.CompanyRepository
import com.capstone2021.scouter.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service

@Service
class CompanyServiceImplementation : CompanyService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    override fun saveCompany(company: Company) {

        this.companyRepository.save(company)

    }

    override fun findAllCompany(): List<Company> {
        return this.companyRepository.findAll()
    }

    override fun findCompany(id: Long): Company {
        return this.companyRepository.getById(id)
    }

    override fun countCompany(): Long {
        return this.companyRepository.count()
    }


}