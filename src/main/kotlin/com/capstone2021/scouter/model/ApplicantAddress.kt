package com.capstone2021.scouter.model

import com.capstone2021.scouter.model.enum.ApplicantAddressType
import javax.persistence.*



@Entity
class ApplicantAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
    @Enumerated(EnumType.STRING)
    private var addressType:ApplicantAddressType? = null
    private var streetNumber:String? = null
    private var streetName:String? = null
    private var city:String? = null
    private var parish:String?= null
    private var county:String? = null
    private var country: String? = null

    constructor(
        addressType: ApplicantAddressType?,
        streetNumber: String?,
        streetName: String?,
        city: String?,
        parish: String?,
        county: String?,
        country: String?
    ) {
        this.addressType = addressType
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

    fun getAddressType(): ApplicantAddressType?{
        return this.addressType
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