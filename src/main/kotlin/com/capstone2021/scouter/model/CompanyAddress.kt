package com.capstone2021.scouter.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class CompanyAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0
    private var streetNumber:String? = null
    private var streetName:String? = null
    private var city:String? = null
    private var parish:String?= null
    private var county:String? = null
    private var country: String? = null

}