package com.capstone2021.scouter.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.*

@Entity
class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyID", nullable = false, updatable = false)
    private var companyId: Long? = null

    @Column(name = "companyName", nullable = false, updatable = true)
    private var companyName: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "companySize", nullable = false, updatable = true)
    private var companySize: CompanySize? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "company_addresses",
        joinColumns = [javax.persistence.JoinColumn(name = "companyId", referencedColumnName = "companyId")],
        inverseJoinColumns = [JoinColumn(name = "address_id", referencedColumnName = "id")]
    )
    private var companyAddress: List<CompanyAddress>? = null

    @NotNull
    @Column(name = "taxRegistrationNumber", unique = true)
    private var taxRegistrationNumber: String? = null

    private var logo: String? = null

    private var headOfCompany: String? = null

    private var isPublicCompany: Boolean? = null

    private var companyEstablishedDate: Date? = null

    private var website: String? = null

    private var email: String? = null


    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "company_jobPosting",
        joinColumns = [javax.persistence.JoinColumn(name = "companyId", referencedColumnName = "companyId")],
        inverseJoinColumns = [JoinColumn(name = "jobPost_id", referencedColumnName = "id")]
    )
    private var jobPostings: MutableList<JobPosting>? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: LocalDateTime? = LocalDateTime.now()

    @UpdateTimestamp
    private var updatedAt: LocalDateTime? = null

    constructor(
        companyName: String?,
        companySize: CompanySize?,
        companyAddress: List<CompanyAddress>?,
        taxRegistrationNumber: String?,
        logo: String?,
        headOfCompany: String?,
        isPublicCompany: Boolean?,
        companyEstablishedDate: Date?,
        website: String?,
        email: String?
    ) {
        this.companyName = companyName
        this.companySize = companySize
        this.companyAddress = companyAddress
        this.taxRegistrationNumber = taxRegistrationNumber
        this.logo = logo
        this.headOfCompany = headOfCompany
        this.isPublicCompany = isPublicCompany
        this.companyEstablishedDate = companyEstablishedDate
        this.website = website
        this.email = email
    }


    fun getId (): Long?{
        return this.companyId
    }

    fun setId (id: Long){
        this.companyId = id
    }

    fun getCompanyName(): String?{
        return this.companyName
    }

    fun setCompanyName (companyName: String){
        this.companyName = companyName
    }


    fun getCompanySize(): CompanySize?{

        return this.companySize

    }

    fun setCompanySize(companySize: CompanySize){
        this.companySize = companySize
    }

    fun getCompanyAddress(): List<CompanyAddress>?{
        return this.companyAddress
    }

    fun getTaxRegistrationNumber(): String? {
        return this.taxRegistrationNumber
    }

    fun setTaxRegistrationNum(trn: String){
        this.taxRegistrationNumber = trn
    }

    fun getCreatedAt(): LocalDateTime?{
        return this.createdAt
    }

    fun getUpdatedAt(): LocalDateTime?{
        return this.updatedAt
    }

    fun getLogo(): String?{
        return this.logo
    }

    fun getHeadOfCompany(): String?{
        return this.headOfCompany
    }

    fun getIsPublicCompany(): Boolean?{
        return this.isPublicCompany
    }

    fun getCompanyEstablishedDate(): Date?{
        return this.companyEstablishedDate
    }


    fun getWebsite (): String?{
        return this.website
    }

    fun getEmail(): String?{
        return this.email
    }

    fun getJobPostings(): List<JobPosting>?{
        return this.jobPostings
    }

    fun addJobPosting(jobPosting: JobPosting){
        jobPostings?.add(jobPosting)
    }





}