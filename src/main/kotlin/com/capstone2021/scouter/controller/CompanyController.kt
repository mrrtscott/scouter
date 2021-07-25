package com.capstone2021.scouter.controller

import com.capstone2021.scouter.model.Company
import com.capstone2021.scouter.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/company")
class CompanyController {

    @Autowired
    lateinit var companyService: CompanyService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody company:Company){
        return companyService.saveCompany(company)
    }

    @GetMapping
    fun findAll(): List<Company?>? {
        return companyService.findAllCompany()
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable("id") id: Long): Company? {
        return companyService.findCompany(id)
    }

    @GetMapping(value = ["/count"])
    fun count() :Long? {
        return companyService.countCompany()
    }


    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: Long) {
        companyService.deleteById(id)
    }


}