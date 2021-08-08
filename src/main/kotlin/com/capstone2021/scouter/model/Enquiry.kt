package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.EnquiryStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Column(columnDefinition = "TEXT")
    private var title: String? = null

    @Column(columnDefinition = "TEXT")
    private var question: String? = null

    @Column(columnDefinition = "TEXT")
    private var response: String? = null

    @Enumerated(EnumType.STRING)
    private var status: EnquiryStatus? = null

    @CreationTimestamp
    @Column(updatable = false)
    private var createdAt: Date? = null

    @UpdateTimestamp
    private var updatedAt: Date? = null

    fun getId(): Long?{
        return this.id
    }

    fun getTitle(): String?{
        return this.title
    }

    fun getQuestion(): String?{
        return this.question
    }

    fun getResponse():String?{
        return this.response
    }

    fun getStatus(): EnquiryStatus?{
        return this.status
    }

    fun getCreatedAt(): Date?{
        return this.createdAt
    }

    fun getUpdatedAtt(): Date?{
        return this.updatedAt
    }

    fun setResponse(response: String){
        this.response = response
    }

    fun setStatus(status: EnquiryStatus){
        this.status = status
    }

    constructor(title: String?, question: String?) {
        this.title = title
        this.question = question
        this.status = EnquiryStatus.OPEN
    }
}