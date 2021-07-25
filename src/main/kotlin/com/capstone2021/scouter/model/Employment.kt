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
    private var id: Long? = null

    private var placeOfEmployment: String? = null

    private var employmentType: EmploymentType? = null

    private var employmentStartDate: Date? = null

    private var employmentEndDate: Date? = null

    private var remarks: String? = null

    constructor(
        placeOfEmployment: String?,
        employmentType: EmploymentType?,
        employmentStartDate: Date?,
        employmentEndDate: Date?,
        remarks: String?
    ) {
        this.placeOfEmployment = placeOfEmployment
        this.employmentType = employmentType
        this.employmentStartDate = employmentStartDate
        this.employmentEndDate = employmentEndDate
        this.remarks = remarks
    }

    fun getPlaceOfEmployment(): String?{
        return this.placeOfEmployment
    }

    fun getEmploymentType(): EmploymentType?{
        return this.employmentType
    }

    fun getEmploymentStartDate(): Date?{
        return this.employmentStartDate
    }

    fun getEmploymentEndDate(): Date?{
        return this.employmentEndDate
    }




}