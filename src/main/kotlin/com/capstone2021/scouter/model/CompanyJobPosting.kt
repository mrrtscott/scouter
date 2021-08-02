package com.capstone2021.scouter.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import net.minidev.json.annotate.JsonIgnore


class CompanyJobPosting {

    private var company: Company? = null
    private var jobPosting: JobPosting? = null

    constructor(company: Company?, jobPosting: JobPosting?) {
        this.company = company
        this.jobPosting = jobPosting
    }


    fun getCompany(): Company?{
        return this.company
    }

    fun getJobPosting(): JobPosting?{
        return this.jobPosting
    }

}