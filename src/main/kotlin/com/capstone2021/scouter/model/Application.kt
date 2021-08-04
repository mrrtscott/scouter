package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.ApplicationStatus
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


    fun getJob (): JobPosting?{
        return this.job
    }

    fun getApplicant(): Applicant?{
        return this.applicant
    }

    fun getScore(): Double?{
        return this.score
    }

    fun getStatus(): ApplicationStatus?{
        return this.status
    }

    fun getCurrentStage(): String?{
        return this.currentStage
    }

    fun getDateCreated(): Date?{
        return this.dateCreated
    }

    fun getDateUpdated(): Date?{
        return this.dateUpdated
    }


    fun setJob(job: JobPosting){
        this.job = job
    }

    fun setApplicant(applicant: Applicant) {
        this.applicant = applicant
    }










}