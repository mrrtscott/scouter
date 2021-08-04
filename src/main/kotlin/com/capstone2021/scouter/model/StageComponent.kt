package com.capstone2021.scouter.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class StageComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null


    private var name: String? = null


    @Column(columnDefinition = "TEXT")
    private var details: String? = null


    private var requiredDate: Date? = null


    private var endDate: Date? = null


    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: Date? = null

    @UpdateTimestamp
    private var updatedAt: Date? = null


    constructor(name: String?, details: String?, requiredDate: Date?, endDate: Date?) {
        this.name = name
        this.details = details
        this.requiredDate = requiredDate
        this.endDate = endDate
    }


    fun getId(): Long?{
        return this.id
    }

    fun getName(): String?{
        return this.name
    }

    fun getDetails(): String?{
        return this.details
    }

    fun getRequiredDate(): Date?{
        return this.requiredDate
    }

     fun getEndDate(): Date?{
         return this.endDate
     }


     fun getCreatedAt(): Date?{
         return this.createdAt
     }

    fun getUpdatedAt(): Date?{
        return this.updatedAt
    }

}