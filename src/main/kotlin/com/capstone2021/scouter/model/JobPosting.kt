package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.EmploymentType
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

    private var description: String? = null

    private var position: String? = null

    private var employmentType:EmploymentType? = null

    private var duration: Double? = null

    private var basicYearlySalary: Double? = null

    private var minAge: Int? = null

    private var maxAge: Int? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "jobPosting_educationRequirement",
        joinColumns = [javax.persistence.JoinColumn(name = "jobPosting_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "educationRequirement_id", referencedColumnName = "id")]
    )
    private var educationRequirements: List<EducationRequirement>? = null

    private var employmentRequirements: List<EmploymentRequirement>? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "jobPosting_skillRequirement",
        joinColumns = [javax.persistence.JoinColumn(name = "jobPosting_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "skillRequirement_id", referencedColumnName = "id")]
    )
    private var skillRequirements: List<SkillRequirements>? = null

    private var jobPostingStatus: JobPostingStatus? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: LocalDateTime? = LocalDateTime.now()

    @UpdateTimestamp
    private var updatedAt: Date? = null
}