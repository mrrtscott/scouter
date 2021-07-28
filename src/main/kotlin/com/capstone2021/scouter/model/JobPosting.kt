package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.JobPostingStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    private var company: Company? = null









    private var jobPostingStatus: JobPostingStatus? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: LocalDateTime? = LocalDateTime.now()

    @UpdateTimestamp
    private var updatedAt: Date? = null
}