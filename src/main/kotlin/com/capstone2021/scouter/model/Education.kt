package com.capstone2021.scouter.model

import java.util.*
import javax.persistence.*

@Entity
class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    private var level: EducationLevel? = null

    private var institution: String? = null

    @Enumerated(EnumType.STRING)
    private var attainment: EducationAttainment? = null

    private var startDate: Date? = null

    private var endDate: Date? = null


    constructor(
        level: EducationLevel?,
        institution: String?,
        attainment: EducationAttainment?,
        startDate: Date?,
        endDate: Date?
    ) {
        this.level = level
        this.institution = institution
        this.attainment = attainment
        this.startDate = startDate
        this.endDate = endDate
    }


    fun getId(): Long?{
        return this.id
    }

    fun getLevel(): EducationLevel?{
        return this.level
    }

    fun getInstitution():String?{
        return this.institution
    }

    fun getAttainment(): EducationAttainment?{
        return this.attainment
    }

    fun getStartDate(): Date?{
        return this.startDate
    }

    fun getEndDate(): Date?{
        return this.endDate
    }



    fun setLevel(educationLevel: EducationLevel){
        this.level = educationLevel
    }

    fun setInstitution(institution: String?){
        this.institution = institution
    }

    fun setAttainment(educationAttainment: EducationAttainment){
        this.attainment = educationAttainment
    }

    fun setStartDate(startDate: Date?){
        this.startDate = startDate
    }

    fun setEndDate(endDate: Date?){
        this.endDate = endDate
    }










}