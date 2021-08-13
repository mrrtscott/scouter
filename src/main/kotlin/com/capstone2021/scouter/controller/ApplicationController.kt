package com.capstone2021.scouter.controller

import com.capstone2021.scouter.model.*
import com.capstone2021.scouter.model.enum.ApplicationStatus
import com.capstone2021.scouter.repository.ApplicantRepository
import com.capstone2021.scouter.repository.ApplicationRepository
import com.capstone2021.scouter.repository.CompanyRepository
import com.capstone2021.scouter.repository.JobPostRepository
import com.capstone2021.scouter.service.ApplicantService
import com.capstone2021.scouter.service.ApplicationService
import com.capstone2021.scouter.service.FileStorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.ByteArrayOutputStream


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

    @Autowired
    lateinit var applicationService: ApplicationService

    @Autowired
    lateinit var applicantService: ApplicantService

    @Autowired
    lateinit var fileStorageService: FileStorageService

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
    fun findApplicantsPerJob(@RequestParam(name = "job" ) job:Long, @RequestParam(name = "status")status:String): List<Any> {
      return this.applicantService.getEachApplicantPerJob(job, status)

    }

    @GetMapping("/get-details/{applicationId}")
    fun getApplicationInfo(@PathVariable("applicationId") applicationId: Long): MutableList<Any?> {
        var activeApplication = applicationRepository.getById(applicationId)
        var jobId = activeApplication.getJob()?.getId()
        var activeCompany = jobId?.let { companyRepository.getCompanyByJobPostId(it) }

        return mutableListOf(activeCompany, activeApplication)

    }

//    @GetMapping("/download-file")
//    fun getApplicationFile(@RequestParam(name = "path") path: String, @RequestParam(name = "key") key:String): ByteArray? {
//        return fileStorageService.download(path, key)
//
//    }

    @GetMapping("/download-file")
    fun downloadFile(@RequestParam(name = "path") path: String, @RequestParam(name = "key") key:String): ResponseEntity<ByteArray?>? {
        val downloadInputStream: ByteArrayOutputStream = fileStorageService.downloadFile(path,key)!!
        return ResponseEntity.ok()
            .contentType(contentType(key)!!)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"$key\"")
            .body(downloadInputStream.toByteArray())
    }

    private  fun contentType(filename: String): MediaType? {
        val fileArrSplit = filename.split("\\.".toRegex()).toTypedArray()
        val fileExtension = fileArrSplit[fileArrSplit.size - 1]
        return when (fileExtension) {
            "txt" -> MediaType.TEXT_PLAIN
            "png" -> MediaType.IMAGE_PNG
            "jpg" -> MediaType.IMAGE_JPEG
            "pdf" -> MediaType.APPLICATION_PDF
            else -> MediaType.APPLICATION_OCTET_STREAM
        }
    }

    @PostMapping("/add-new-enquiry/{applicationId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun newEnquiry(@PathVariable("applicationId") applicationId: Long, @RequestBody enquiry:Enquiry){
        var activeApplication  = applicationService.findApplication(applicationId)
        activeApplication?.addEnquiry(enquiry)
        if (activeApplication != null) {
            applicationService.save(activeApplication)
        }

    }


    @PostMapping("/{applicationId}/set-status")
    fun changeStatus(
        @PathVariable("applicationId") applicationId: Long,
        @RequestParam(name = "status") status: ApplicationStatus
    ) {
        applicationService.findApplication(applicationId)?.setStatus(status)
    }

    @PostMapping("/{applicationId}/set-score")
    fun changeScore(
        @PathVariable("applicationId") applicationId: Long,
        @RequestParam(name = "score") score: Double
    ) {
        applicationService.findApplication(applicationId)?.setScore(score)
    }


    @GetMapping("/selected-applicants/{jobId}")
    fun getSelectedApplicants(@PathVariable("jobId") jobId: Long): List<Any>{
        return this.applicationService.findSelectedApplicants(jobId)
    }



}