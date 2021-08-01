package com.capstone2021.scouter.controller

import com.capstone2021.scouter.model.Company
import com.capstone2021.scouter.model.JobPosting
import com.capstone2021.scouter.service.CompanyService
import com.capstone2021.scouter.service.JobPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jobPosting")
class JobPostingController {

    @Autowired
    lateinit var jobPostingService: JobPostService

    @Autowired
    lateinit var companyService: CompanyService


    @GetMapping
    fun findAll(): List<JobPosting>?{
        return this.jobPostingService.findAll()
    }

    @PostMapping (value = ["/{companyId}"])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@PathVariable("companyId") companyId: Long, @RequestBody jobPosting: JobPosting){
        var activeCompany: Company = companyService.findCompany(companyId)
        jobPostingService.saveJobPost(activeCompany, jobPosting)
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable("id") id: Long): JobPosting{
        return jobPostingService.findJobPost(id)

    }

    @PutMapping(value = ["/{companyId}/{jobPostId}"])
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable("companyId") companyId: Long?, @PathVariable ("jobPostId") jobPostId:Long , @RequestBody jobPosting: JobPosting){
        var subJob: JobPosting = jobPostingService.findJobPost(jobPostId)
        if(jobPosting != null && subJob != null){
            jobPostingService.updateJobPost(jobPosting)
        }

    }



}