package com.capstone2021.scouter.controller

import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.Company
import com.capstone2021.scouter.model.JobPosting
import com.capstone2021.scouter.repository.ApplicantRepository
import com.capstone2021.scouter.repository.ApplicationRepository
import com.capstone2021.scouter.repository.CompanyRepository
import com.capstone2021.scouter.repository.JobPostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/application")
class ApplicationController {

    @Autowired
    lateinit var applicationRepository: ApplicationRepository

    @Autowired
    lateinit var jobPostRepository: JobPostRepository

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var applicantRepository: ApplicantRepository

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestParam(name = "applicantId" ) applicantId:Long,@RequestParam(name = "companyId" ) companyId:Long, @RequestParam(name = "jobPostId") jobPostId:Long){

        var activeApplicant = applicantRepository.getById(applicantId)

        var company: Company = companyRepository.getById(companyId)
        var application = Application()
        var job = jobPostRepository.getById(jobPostId)
        application.setApplicant(activeApplicant)
        application.setJob(job)

        applicationRepository.save(application)



    }

    @GetMapping
    fun findAll(): List<Application>{
       return this.applicationRepository.findAll()

    }

    @GetMapping(value = ["/{id}"])
    fun findApplication(@PathVariable("id") id: Long, @RequestParam(name = "type" ) type:String): List<Application>{
        var output: List<Application>? = null
        if (type.equals("applications", ignoreCase = true)){
            output = applicationRepository.getApplicationsForApplicant(id)
        }
        return output!!.toList()
    }



}