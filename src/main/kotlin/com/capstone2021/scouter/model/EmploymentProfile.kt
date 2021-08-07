package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.EmploymentStatus
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class EmploymentProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdDate: Date? = null

    @UpdateTimestamp
    private var updateDate: Date? = null


    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "employmentProfile_listOfEmployment",
        joinColumns = [javax.persistence.JoinColumn(name = "employmentProfileId", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "employmentId", referencedColumnName = "id")]
    )
    private var listOfEmployment: List<Employment>? = null


    @Enumerated(EnumType.STRING)
    private var employmentStatus: EmploymentStatus? = null


    constructor(listOfEmployment: List<Employment>?, employmentStatus: EmploymentStatus?) {
        this.listOfEmployment = listOfEmployment
        this.employmentStatus = employmentStatus
    }


    fun getId(): Long?{
        return this.id
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getCreatedDate(): Date?{
        return this.createdDate
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getUpdateDate(): Date?{
        return this.updateDate
    }

    fun getEmploymentStatus(): EmploymentStatus?{
        return this.employmentStatus
    }

    fun getListOfEmployment(): List<Employment>?{
        return this.listOfEmployment
    }

}