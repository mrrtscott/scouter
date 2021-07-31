package com.capstone2021.scouter.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class EmploymentRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    private var minYearsExperience: Int? = null


    private var experiencePosition: String? = null

    fun getId(): Long?{
        return this.id
    }

    fun getMinYearsExperience(): Int?{
        return this.minYearsExperience
    }

    fun getExperiencePosition(): String?{
        return this.experiencePosition
    }


    constructor(minYearsExperience: Int?, experiencePosition: String?) {
        this.minYearsExperience = minYearsExperience
        this.experiencePosition = experiencePosition
    }







}