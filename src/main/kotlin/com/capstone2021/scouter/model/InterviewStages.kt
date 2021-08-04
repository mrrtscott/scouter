package com.capstone2021.scouter.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.awt.print.Book
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class InterviewStages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    private var stageName: String? =null

    @Column(columnDefinition = "TEXT")
    private var stageDescription:String? = null


    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "Interview_Components",
        joinColumns = [javax.persistence.JoinColumn(name = "Interview_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "Component_id", referencedColumnName = "id")]
    )
    private var stageComponent :List<StageComponent>? = null

    private var isRequired: Boolean? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: Date? = null

    @UpdateTimestamp
    private var updatedAt: Date? = null

    constructor(
        stageName: String?,
        stageDescription: String?,
        stageComponent: List<StageComponent>?,
        isRequired: Boolean?
    ) {
        this.stageName = stageName
        this.stageDescription = stageDescription
        this.stageComponent = stageComponent
        this.isRequired = isRequired
    }


    fun getId(): Long?{
        return this.id
    }

    fun getStageName(): String?{
        return this.stageName
    }

    fun getStageDescription(): String?{
        return this.stageDescription
    }

    fun getCreatedAt(): Date?{
        return this.createdAt
    }

    fun getUpdatedAt(): Date?{
        return this.updatedAt
    }


}