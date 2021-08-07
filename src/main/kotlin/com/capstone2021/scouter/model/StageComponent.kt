package com.capstone2021.scouter.model

import com.fasterxml.jackson.annotation.JsonFormat
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getRequiredDate(): Date?{
        return this.requiredDate
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
     fun getEndDate(): Date?{
         return this.endDate
     }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
     fun getCreatedAt(): Date?{
         return this.createdAt
     }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getUpdatedAt(): Date?{
        return this.updatedAt
    }

}