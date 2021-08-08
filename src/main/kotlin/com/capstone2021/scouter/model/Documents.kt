package com.capstone2021.scouter.model

import com.fasterxml.jackson.annotation.JsonFormat
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

    private var path: String? = null

    private var url: String? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: Date? = null

    @UpdateTimestamp
    private var updatedAt: Date? = null


    constructor(name: String?,path:String?, url: String?) {
        this.name = name
        this.path = path
        this.url = url
    }

    fun getId(): Long?{
        return this.id
    }


    fun getName(): String?{
        return this.name
    }

    fun getPath(): String?{
        return this.path
    }


    fun getUrl(): String?{
        return this.url
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