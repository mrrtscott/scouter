package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.ApplicantStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table (name = "Applicant")
class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @NotNull
    private var firstName: String? = null

    private var middleName: String? = null

    @NotNull
    private var lastName: String? = null

    @NotNull
    private var dateOfBirth: Date? = null

    @NotNull
    private var nationality: String? = null

    @NotNull
    @Column(unique = true, updatable = false)
    private var taxRegistrationNumber: String? = null


    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "applicant_addresses",
        joinColumns = [javax.persistence.JoinColumn(name = "applicantId", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "address_id", referencedColumnName = "id")]
    )
    private var applicantAddress: List<ApplicantAddress>? = null

    @Enumerated(EnumType.STRING)
    private var applicantStatus:ApplicantStatus? = ApplicantStatus.PENDING

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "employmentProfileId", referencedColumnName = "id")
    private var employmentProfile: EmploymentProfile? = null


    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "educationProfileId", referencedColumnName = "id")
    private var eductionProfile: EducationProfile? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: LocalDateTime? = LocalDateTime.now()

    @UpdateTimestamp
    private var updatedAt: Date? = null



    constructor(
        firstName: String?,
        middleName: String?,
        lastName: String?,
        dateOfBirth: Date?,
        nationality: String?,
        taxRegistrationNumber: String?,
        applicantAddress: List<ApplicantAddress>?,
        applicantStatus: ApplicantStatus?,
        employmentProfile: EmploymentProfile?,
        eductionProfile: EducationProfile?
    ) {
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.dateOfBirth = dateOfBirth
        this.nationality = nationality
        this.taxRegistrationNumber = taxRegistrationNumber
        this.applicantAddress = applicantAddress
        this.applicantStatus = applicantStatus
        this.employmentProfile = employmentProfile
        this.eductionProfile = eductionProfile
    }


    fun getId ():  Long?{
        return this.id
    }


    fun getFirstName (): String?{
        return this.firstName
    }

    fun getMiddleName(): String? {
        return this.middleName
    }

    fun getLastName(): String? {
        return this.lastName
    }

    fun getDateOfBirth(): Date?{
        return this.dateOfBirth
    }

    fun getNationality(): String? {
        return this.nationality
    }

    fun getTaxRegistrationNumber(): String?{
        return this.taxRegistrationNumber
    }

    fun getApplicantAddress(): List<ApplicantAddress>?{
        return this.applicantAddress
    }

    fun getApplicantStatus(): ApplicantStatus?{
        return this.applicantStatus
    }

    fun getEmploymentProfile(): EmploymentProfile?{
        return this.employmentProfile
    }

    fun getEductionProfile(): EducationProfile?{
        return this.eductionProfile
    }

    fun getCreatedAt(): LocalDateTime?{
        return this.createdAt
    }


    fun getUpdatedAt(): Date?{
        return this.updatedAt
    }







}