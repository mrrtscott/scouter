package com.capstone2021.scouter.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0

    @CreationTimestamp
    private var dateCreated: Date? = null

    @UpdateTimestamp
    private var dateUpdated: Date? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "jobPost_id", referencedColumnName = "id")
    private var job: JobPosting? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "applicantId", referencedColumnName = "id")
    private var applicant: Applicant? = null










}