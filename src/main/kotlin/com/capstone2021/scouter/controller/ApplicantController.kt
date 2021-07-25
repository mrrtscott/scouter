package com.capstone2021.scouter.controller

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.service.ApplicantService
import com.capstone2021.scouter.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/applicant")
class ApplicantController {

    @Autowired
    lateinit var applicantService: ApplicantService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody applicant:Applicant){
        return applicantService.saveApplicant(applicant)
    }

    @GetMapping
    fun findAll(): List<Applicant>?{
        return applicantService.findAllApplicants()
    }




}