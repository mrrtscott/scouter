package com.capstone2021.scouter.controller

import com.capstone2021.scouter.algorithms.CompareStrings
import com.capstone2021.scouter.algorithms.Cosine
import com.capstone2021.scouter.model.*
import com.capstone2021.scouter.service.ApplicantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@CrossOrigin
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

    @PostMapping(
        path = ["/{applicantId}/profile-image"],
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun uploadUserProfileImage(@PathVariable("applicantId") applicantId: Long?, @RequestParam("file") file: MultipartFile?) {
        if (applicantId != null) {
            if (file != null) {
                applicantService.addProfileImage(applicantId, file)
            }
        }



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
    fun applicantDashboard(@PathVariable("id") id: Long?): MutableList<CompanyJobPosting>?{
        var jobPostings:MutableList<CompanyJobPosting>? = mutableListOf()
        var applicant = applicantService.findApplicant(id!!.toLong())

        if (applicant != null) {
            jobPostings =  applicantService.getQualifiedJobs(applicant)
        }

        return jobPostings



    }

    @GetMapping("/skillCompare")
    fun viewApplicantsJob(@RequestParam(name = "applicant1" ) applicant1:Long, @RequestParam(name = "applicant2")applicant2: Long, @RequestParam(name = "job") job: Long): MutableList<ApplicantRadar>{
        return applicantService.getTwoApplicantsWithJob(applicant1, applicant2, job)
    }

    //FOR TESTING ONLY
    @GetMapping("/word")
    fun viewJobsQualifiedFor(@RequestParam(name = "word1") word1: String?,@RequestParam(name = "word2") word2: String? ):Double{
        var compareStrings = CompareStrings()
        var cosine = Cosine()

        return (compareStrings.calculate(word1.toString(), word2.toString())).toDouble()


    }





}