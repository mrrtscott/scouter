package com.capstone2021.scouter.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class EducationProfile {


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
        name = "educationProfile_listOfEdu",
        joinColumns = [javax.persistence.JoinColumn(name = "educationProfileId", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "educationId", referencedColumnName = "id")]
    )
    private var listOfEducation: List<Education>? = null

    constructor(listOfEducation: List<Education>?) {
        this.listOfEducation = listOfEducation
    }


    fun getId(): Long?{
        return this.id
    }

    fun getListOfEducation(): List<Education>?{
        return this.listOfEducation
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getCreatedDate(): Date?{
        return this.createdDate
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getUpdateDate(): Date?{
        return this.updateDate
    }








}