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
    @Column(updatable = false)
    private var id: Long? = null

    private var description: String? = null

    private var position: String? = null

    @Enumerated(EnumType.STRING)
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

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "jobPosting_employmentRequirement",
        joinColumns = [javax.persistence.JoinColumn(name = "jobPosting_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "employmentRequirement_id", referencedColumnName = "id")]
    )
    private var employmentRequirements: List<EmploymentRequirement>? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "jobPosting_skillRequirement",
        joinColumns = [javax.persistence.JoinColumn(name = "jobPosting_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "skillRequirement_id", referencedColumnName = "id")]
    )
    private var skillRequirements: List<SkillRequirements>? = null

    @Enumerated(EnumType.STRING)
    private var jobPostingStatus: JobPostingStatus? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: LocalDateTime? = LocalDateTime.now()

    @UpdateTimestamp
    private var updatedAt: Date? = null


    fun getId(): Long?{
        return this.id
    }

    fun getDescription (): String?{
        return this.description
    }

    fun getPosition(): String?{
        return this.position
    }

    fun getEmploymentType():EmploymentType?{
        return this.employmentType
    }

    fun getDuration(): Double?{
        return this.duration
    }

    fun getBasicYearlySalary (): Double?{
        return this.basicYearlySalary
    }

    fun getMinAge(): Int?{
        return this.minAge
    }

    fun getMaxAge(): Int?{
        return this.maxAge
    }

    fun getEducationRequirements(): List<EducationRequirement>?{
        return this.educationRequirements
    }

    fun getEmploymentRequirements(): List<EmploymentRequirement>?{
        return this.employmentRequirements
    }

    fun getSkillRequirements(): List<SkillRequirements>?{
        return this.skillRequirements
    }

    fun getUpdatedAt(): Date?{
        return this.updatedAt
    }

    fun getCreatedAt(): LocalDateTime?{
        return this.createdAt
    }





    fun setDescription (description :String?){
        this.description = description
    }

    fun setPosition(position: String?){
         this.position = position
    }

    fun setEmploymentType(employmentType: EmploymentType?){
        this.employmentType = employmentType
    }

    fun setDuration(duration: Double?){
        this.duration = duration
    }

    fun setBasicYearlySalary (basicYearlySalary: Double?){
        this.basicYearlySalary = basicYearlySalary
    }

    fun setMinAge(minAge: Int?){
        this.minAge = minAge
    }

    fun setMaxAge(maxAge: Int?){
        this.maxAge = maxAge
    }

    fun setEducationRequirements(educationRequirements: List<EducationRequirement>?){
        this.educationRequirements = educationRequirements
    }

    fun setEmploymentRequirements(employmentRequirements: List<EmploymentRequirement>?){
        this.employmentRequirements = employmentRequirements
    }

    fun setSkillRequirements(skillRequirements: List<SkillRequirements>?){
        this.skillRequirements = skillRequirements
    }





    constructor(
        description: String?,
        position: String?,
        employmentType: EmploymentType?,
        duration: Double?,
        basicYearlySalary: Double?,
        minAge: Int?,
        maxAge: Int?,
        educationRequirements: List<EducationRequirement>?,
        employmentRequirements: List<EmploymentRequirement>?,
        skillRequirements: List<SkillRequirements>?,
        jobPostingStatus: JobPostingStatus?
    ) {
        this.description = description
        this.position = position
        this.employmentType = employmentType
        this.duration = duration
        this.basicYearlySalary = basicYearlySalary
        this.minAge = minAge
        this.maxAge = maxAge
        this.educationRequirements = educationRequirements
        this.employmentRequirements = employmentRequirements
        this.skillRequirements = skillRequirements
        this.jobPostingStatus = jobPostingStatus
    }







}