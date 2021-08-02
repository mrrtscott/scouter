package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.ProspectiveJobType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity
class ProspectiveJob {

    @Id
    private var id: Long? = null

    private var minimumSalary: Double? = null

    @Enumerated(EnumType.STRING)
    private var jobType: ProspectiveJobType? = null

    private var position: String? = null


    fun getMinimumSalary(): Double?{
        return this.minimumSalary
    }

    fun getJobType(): ProspectiveJobType?{
        return this.jobType
    }

    fun getPosition(): String?{
        return this.position
    }

    constructor(minimumSalary: Double?, jobType: ProspectiveJobType?, position: String?) {
        this.minimumSalary = minimumSalary
        this.jobType = jobType
        this.position = position
    }





}