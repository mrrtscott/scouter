package com.capstone2021.scouter.model

class ApplicantRadar {

    private var applicant:Applicant? = null
    private var numberOfSkillsMatched: Int? = 0
    private var numberOfEducationAttainment:Int? = 0
    private var cumulativeJobExperience:Int? =0

    constructor(applicant: Applicant?, numberOfSkillsMatched: Int?, numberOfEducationAttainment: Int?, cumulativeJobExperience: Int?) {
        this.applicant = applicant
        this.numberOfSkillsMatched = numberOfSkillsMatched
        this.numberOfEducationAttainment = numberOfEducationAttainment
        this.cumulativeJobExperience = cumulativeJobExperience
    }

    fun getApplicant(): Applicant?{
        return this.applicant
    }

    fun getNumberOfSkillsMatched(): Int?{
        return this.numberOfSkillsMatched
    }

    fun getNumberOfEducationAttainment(): Int?{
        return this.numberOfEducationAttainment
    }

    fun getCumulativeJobExperience(): Int?{
        return this.cumulativeJobExperience
    }


}