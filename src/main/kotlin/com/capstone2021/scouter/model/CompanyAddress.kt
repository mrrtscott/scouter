package com.capstone2021.scouter.model

import javax.persistence.*


@Entity
class CompanyAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    private var streetNumber:String? = null
    private var streetName:String? = null
    private var city:String? = null
    private var parish:String?= null
    private var county:String? = null
    private var country: String? = null

    constructor(
        streetNumber: String?,
        streetName: String?,
        city: String?,
        parish: String?,
        county: String?,
        country: String?
    ) {
        this.id = id
        this.streetNumber = streetNumber
        this.streetName = streetName
        this.city = city
        this.parish = parish
        this.county = county
        this.country = country
    }

    fun getId():Long?{
        return this.id
    }

    fun getStreetNumber(): String? {
        return this.streetNumber
    }

    fun getStreetName(): String? {
        return this.streetName
    }

    fun getCity (): String? {
        return this.city
    }

    fun getParish (): String?{
        return this.parish
    }

    fun getCounty(): String? {
        return this.county
    }

    fun getCountry (): String? {
        return this.country
    }


}