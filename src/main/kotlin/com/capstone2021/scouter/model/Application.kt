package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.ApplicationStatus
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class Application {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id:Long?=null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "jobPost_id", referencedColumnName = "id")
    private var job: JobPosting? = null

    @Enumerated(EnumType.STRING)
    private var status: ApplicationStatus? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "applicantId", referencedColumnName = "id")
    private var applicant: Applicant? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "application_documents",
        joinColumns = [javax.persistence.JoinColumn(name = "application_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "documents_id", referencedColumnName = "id")]
    )
    private var documents: MutableList<Documents>? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "application_enquiry",
        joinColumns = [javax.persistence.JoinColumn(name = "application_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "enquiry_id", referencedColumnName = "id")]
    )
    private var enquiry: MutableList<Enquiry>? = null

    private var currentStage: String? = null

    private var score: Double? = null


    @CreationTimestamp
    private var dateCreated: Date? = null

    @UpdateTimestamp
    private var dateUpdated: Date? = null

    constructor(job: JobPosting?, applicant: Applicant?) {
        this.job = job
        this.status = ApplicationStatus.OPEN
        this.applicant = applicant
        this.score = 0.00
    }

    fun getId(): Long?{
        return this.id
    }


    fun getJob (): JobPosting?{
        return this.job
    }

    fun getApplicant(): Applicant?{
        return this.applicant
    }

    fun getScore(): Double?{
        return this.score
    }

    //4707804
    fun getStatus(): ApplicationStatus?{
        return this.status
    }

    fun getEnquiry():MutableList<Enquiry>?{
        return this.enquiry
    }

    fun getCurrentStage(): String?{
        return this.currentStage
    }

    fun getDocument(): List<Documents>?{
        return this.documents
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getDateCreated(): Date?{
        return this.dateCreated
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getDateUpdated(): Date?{
        return this.dateUpdated
    }




    fun setJob(job: JobPosting){
        this.job = job
    }

    fun setApplicant(applicant: Applicant) {
        this.applicant = applicant
    }

    fun addDocuments(document: Documents){
        documents?.add(document)

    }


    fun setStatus(status: ApplicationStatus){
        this.status = status
    }

    fun setScore(score: Double){
        this.score = score
    }

    fun addEnquiry(enquiry: Enquiry){
        this.enquiry?.add(enquiry)
    }










}