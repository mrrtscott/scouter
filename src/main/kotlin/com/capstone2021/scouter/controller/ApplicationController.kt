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

    /**
     * Create an application
     * @param applicantId
     * @param companyId
     * @param jobPostId
     *
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestParam(name = "applicantId" ) applicantId:Long,@RequestParam(name = "companyId" ) companyId:Long, @RequestParam(name = "jobPostId") jobPostId:Long){

        var activeApplicant = applicantRepository.getById(applicantId)

        var company: Company = companyRepository.getById(companyId)

        var job = jobPostRepository.getById(jobPostId)
        var application = Application(job, activeApplicant)

        applicationRepository.save(application)



    }

    /**
     * Display all job applications
     * @return List of applications
     */
    @GetMapping
    fun findAll(): List<Application>{
       return this.applicationRepository.findAll()

    }

    /**
     * Display all applications made by a specific applicant
     * @param id
     * @param type
     * @return List of applications
     */
    @GetMapping(value = ["/{id}"])
    fun findApplication(@PathVariable("id") id: Long, @RequestParam(name = "type" ) type:String): List<Application>{
        var output: List<Application>? = null
        if (type.equals("applications", ignoreCase = true)){
            output = applicationRepository.getApplicationsForApplicant(id)
        }
        return output!!.toList()
    }

    /**
     * Display all applicants who have applied for a job post
     * @param job
     * @param status
     * @return Detailed list of applicants which have applied for the post
     */
    @GetMapping("/get-applicants-per-job")
    fun findApplicantsPerJob(@RequestParam(name = "job" ) job:Long, @RequestParam(name = "status")status:String): List<Any> {
      return this.applicantService.getEachApplicantPerJob(job, status)

    }

    /**
     * Display information on a specific application
     * @param applicationId
     * @return Detailed list of information on an application
     */
    @GetMapping("/get-details/{applicationId}")
    fun getApplicationInfo(@PathVariable("applicationId") applicationId: Long): MutableList<Any?> {
        var activeApplication = applicationRepository.getById(applicationId)
        var jobId = activeApplication.getJob()?.getId()
        var activeCompany = jobId?.let { companyRepository.getCompanyByJobPostId(it) }

        return mutableListOf(activeCompany, activeApplication)

    }

    /**
     * Download a file
     * @param path
     * @param key
     * @return file
     */
    @GetMapping("/download-file")
    fun downloadFile(@RequestParam(name = "path") path: String, @RequestParam(name = "key") key:String): ResponseEntity<ByteArray?>? {
        val downloadInputStream: ByteArrayOutputStream = fileStorageService.downloadFile(path,key)!!
        return ResponseEntity.ok()
            .contentType(contentType(key)!!)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"$key\"")
            .body(downloadInputStream.toByteArray())
    }

    /**
     * Get metadata on a file
     * @param String
     * @return file extension
     */
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

    /**
     * Make an enquiry on a jost post
     * @param applicationId
     * @param enquiry
     */

    @PostMapping("/add-new-enquiry/{applicationId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun newEnquiry(@PathVariable("applicationId") applicationId: Long, @RequestBody enquiry:Enquiry){
        var activeApplication  = applicationService.findApplication(applicationId)
        activeApplication?.addEnquiry(enquiry)
        if (activeApplication != null) {
            applicationService.save(activeApplication)
        }

    }

    /**
     * Change the status of an appication
     * @param applicationId
     * @param status
     */
    @PostMapping("/{applicationId}/set-status")
    fun changeStatus(
        @PathVariable("applicationId") applicationId: Long,
        @RequestParam(name = "status") status: ApplicationStatus
    ) {
        applicationService.findApplication(applicationId)?.setStatus(status)
    }

    /**
     * Set the score for an applicantion
     * @param applicationId
     * @param score
     */
    @PostMapping("/{applicationId}/set-score")
    fun changeScore(
        @PathVariable("applicationId") applicationId: Long,
        @RequestParam(name = "score") score: Double
    ) {
        applicationService.findApplication(applicationId)?.setScore(score)
    }

    /**
     * Display selected applicants
     * @param jobId
     * @return List of selected applicants
     */
    @GetMapping("/selected-applicants/{jobId}")
    fun getSelectedApplicants(@PathVariable("jobId") jobId: Long): List<Any>{
        return this.applicationService.findSelectedApplicants(jobId)
    }



}