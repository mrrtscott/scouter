package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.EmploymentType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class Employment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var placeOfEmployment: String? = null

    var employmentType: EmploymentType? = null

    var employmentStartDate: Date? = null

    var employmentEndDate: Date? = null




}