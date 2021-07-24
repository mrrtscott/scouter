package com.capstone2021.scouter.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class EducationProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0

    @CreationTimestamp
    private var createdDate: Date? = null

    @UpdateTimestamp
    private var updateDate: Date? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "educationProfile_address",
        joinColumns = [javax.persistence.JoinColumn(name = "educationProfileId", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "educationId", referencedColumnName = "id")]
    )
    private var listOfEducation: List<Education>? = null








}