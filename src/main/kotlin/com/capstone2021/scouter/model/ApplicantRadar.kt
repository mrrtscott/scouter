package com.capstone2021.scouter.model

class ApplicantRadar {

    private var applicant:Applicant? = null
    private var numberOfSkillsMatched: Int? = 0
    private var numberOfEducationAttainment:Int? = 0

    constructor(applicant: Applicant?, numberOfSkillsMatched: Int?, numberOfEducationAttainment: Int?) {
        this.applicant = applicant
        this.numberOfSkillsMatched = numberOfSkillsMatched
        this.numberOfEducationAttainment = numberOfEducationAttainment
    }


}