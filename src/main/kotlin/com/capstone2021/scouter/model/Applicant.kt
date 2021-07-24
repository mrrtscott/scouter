package com.capstone2021.scouter.model

import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*

@Entity
@Table (name = "Applicant")
class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @NotNull
    var firstName: String? = null

    var middleName: String? = null

    @NotNull
    var lastName: String? = null

    @NotNull
    var dateOfBirth: Date? = null

    @NotNull
    var nationality: String? = null

    @NotNull
    @Column(unique = true)
    var taxRegistrationNumber: String? = null

    var employmentProfile: EmploymentProfile? = null

    var eductionProfile: EducationProfile? = null




}