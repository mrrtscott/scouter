package com.capstone2021.scouter.model

import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var level: EducationLevel? = null

    var year: Int? = null

    var institution: String? = null

    var attainment: EducationAttainment? = null

    var startDate: Date? = null
    var endDate: Date? = null





}