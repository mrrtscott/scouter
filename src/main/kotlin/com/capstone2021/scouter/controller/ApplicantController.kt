package com.capstone2021.scouter.controller

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Company
import com.capstone2021.scouter.service.ApplicantService
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

    @PutMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable("id") id: Long?, @RequestBody applicant: Applicant) {
        if (applicant != null){
            applicantService.saveApplicant(applicant)
        }
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable("id") id: Long): Applicant? {
        return applicantService.findApplicant(id)
    }




}