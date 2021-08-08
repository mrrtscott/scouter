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


@CrossOrigin
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

        var job = jobPostRepository.getById(jobPostId)
        var application = Application(job, activeApplicant)
//        application.setApplicant(activeApplicant)
//        application.setJob(job)

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

    @GetMapping("/get-applicants-per-job")
    fun findApplicantsPerJob(@RequestParam(name = "job" ) job:Long, @RequestParam(name = "status")status:String): List<Applicant> {
        var allApplicantId= this.applicationRepository.getApplicantsPerJobAll(job)
        var specificApplicantId = this.applicationRepository.getApplicantsPerJob(job, status)

        var allApplicantList = mutableListOf<Applicant>()
        for (id in allApplicantId){
            allApplicantList.add(applicantRepository.getById(id))
        }

        var specificApplicantsList = mutableListOf<Applicant>()
        for (id in specificApplicantId){
            specificApplicantsList.add(applicantRepository.getById(id))
        }


        return if (status == "ALL") return allApplicantList   else {
            return specificApplicantsList
        }

    }

    @GetMapping("/get-details/{applicationId}")
    fun getApplicationInfo(@PathVariable("applicationId") applicationId: Long): MutableList<Any?> {
        var activeApplication = applicationRepository.getById(applicationId)
        var jobId = activeApplication.getJob()?.getId()
        var activeCompany = jobId?.let { companyRepository.getCompanyByJobPostId(it) }

        return mutableListOf(activeCompany, activeApplication)

    }



}