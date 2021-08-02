package com.capstone2021.scouter.controller

import com.capstone2021.scouter.algorithms.CompareStrings
import com.capstone2021.scouter.algorithms.Cosine
import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.Application
import com.capstone2021.scouter.model.Company
import com.capstone2021.scouter.model.JobPosting
import com.capstone2021.scouter.service.ApplicantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/applicant")
class ApplicantController {

    @Autowired
    lateinit var applicantService: ApplicantService

    /**
     *
     */
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

    @GetMapping("/compare")
    fun findApplication(@RequestParam(name = "applicant1" ) applicant1:Long, @RequestParam(name = "applicant2")applicant2: Long): List<Applicant>?{
        var output: List<Applicant>? = null
        output = applicantService.getTwoApplicant(applicant1, applicant2)
        return output
    }

    @GetMapping("/dashboard/{id}")
    fun applicantDashboard(@PathVariable("id") id: Long?): List<JobPosting>?{
        var jobPostings:List<JobPosting>? = null
        var applicant = applicantService.findApplicant(id!!.toLong())

        if (applicant != null) {
            jobPostings =  applicantService.getQualifiedJobs(applicant)
        }

        return jobPostings


    }

    @GetMapping("/word")
    fun viewJobsQualifiedFor(@RequestParam(name = "word1") word1: String?,@RequestParam(name = "word2") word2: String? ):Double{
        var compareStrings = CompareStrings()
        var cosine = Cosine()

        //Should be greater than 0.40
        //return cosine.similarity(word1.toString(), word2.toString())


        return (compareStrings.calculate(word1.toString(), word2.toString())).toDouble()


    }





}