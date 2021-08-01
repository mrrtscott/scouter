package com.capstone2021.scouter.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class EducationRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = 0

    private var description: String? = null

    private var requiredAttainment: EducationAttainment? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdDate: Date? = null

    @UpdateTimestamp
    private var updateDate: Date? = null



    fun getId(): Long?{
        return this.id
    }

    fun getDescription(): String?{
        return this.description
    }

    fun getRequiredAttainment(): EducationAttainment?{
        return this.requiredAttainment
    }

    fun getCreatedDate(): Date?{
        return this.createdDate
    }

    fun getUpdateDate(): Date?{
        return this.updateDate
    }

    constructor(description: String?, requiredAttainment: EducationAttainment?) {
        this.description = description
        this.requiredAttainment = requiredAttainment
    }



}