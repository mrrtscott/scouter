package com.capstone2021.scouter.model

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


    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "applicantId", referencedColumnName = "id")
    private var applicant: Applicant? = null

    private var score: Double? = null


    @CreationTimestamp
    private var dateCreated: Date? = null

    @UpdateTimestamp
    private var dateUpdated: Date? = null


    fun getJob (): JobPosting?{
        return this.job
    }

    fun getApplicant(): Applicant?{
        return this.applicant
    }

    fun getScore(): Double?{
        return this.score
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