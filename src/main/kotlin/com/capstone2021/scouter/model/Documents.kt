package com.capstone2021.scouter.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    private var name: String? = null

    private var description: String? = null

    private var url: String? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: Date? = null

    @UpdateTimestamp
    private var updatedAt: Date? = null


    constructor(name: String?, description: String?, url: String?) {
        this.name = name
        this.description = description
        this.url = url
    }

    fun getId(): Long?{
        return this.id
    }


    fun getName(): String?{
        return this.name
    }

    fun getDescription(): String?{
        return this.description
    }
    fun getUrl(): String?{
        return this.url
    }

    fun getCreatedAt(): Date?{
        return this.createdAt
    }

    fun getUpdatedAt(): Date?{
        return this.updatedAt
    }

}