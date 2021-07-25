package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.JobPostingStatus
import javax.persistence.*

@Entity
class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    private var company: Company? = null


    private var jobPostingStatus: JobPostingStatus? = null
}