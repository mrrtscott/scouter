package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.EmploymentStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class EmploymentProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0

    @CreationTimestamp
    private var createdDate: Date? = null

    @UpdateTimestamp
    private var updateDate: Date? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "employmentProfile_address",
        joinColumns = [javax.persistence.JoinColumn(name = "employmentProfileId", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "employmentId", referencedColumnName = "id")]
    )
    private var listOfEmployment: List<Employment>? = null


    private var employmentStatus: EmploymentStatus? = null

}