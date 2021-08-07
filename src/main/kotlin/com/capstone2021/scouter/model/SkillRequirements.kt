package com.capstone2021.scouter.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*


@Entity
class SkillRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = 0

    private var description: String? = null

    private var skill: String? = null

    private var isRequired: Boolean? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdDate: Date? = null

    @UpdateTimestamp
    private var updateDate: Date? = null


    constructor(description: String?, skill: String?, isRequired: Boolean?) {
        this.description = description
        this.skill = skill
        this.isRequired = isRequired
    }

    fun getId(): Long?{
        return this.id
    }

    fun getDescription(): String?{
        return this.description
    }

    fun getSkill(): String?{
        return this.skill
    }

    fun getIsRequired(): Boolean?{
        return this.isRequired
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getCreatedDate(): Date?{
        return this.createdDate
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    fun getUpdated(): Date?{
        return this.updateDate
    }





}