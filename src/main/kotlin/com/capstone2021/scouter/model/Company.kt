package com.capstone2021.scouter.model

import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyID", nullable = false, updatable = false)
    private var companyId: Long? = null

    @Column(name = "companyName", nullable = false, updatable = true)
    private var companyName: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "companySize", nullable = false, updatable = true)
    private var companySize: CompanySize? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "company_address",
        joinColumns = [javax.persistence.JoinColumn(name = "companyId", referencedColumnName = "companyId")],
        inverseJoinColumns = [JoinColumn(name = "address_id", referencedColumnName = "id")]
    )
    private var companyAddress: List<CompanyAddress>? = null

    @NotNull
    @Column(name = "taxRegistrationNumber", unique = true)
    var taxRegistrationNumber: String? = null

    var createdAt: LocalDateTime? = LocalDateTime.now()



    fun getId (): Long?{
        return this.companyId
    }

    fun setId (id: Long){
        this.companyId = id
    }

    fun getCompanyName(): String?{
        return this.companyName
    }

    fun setCompanyName (companyName: String){
        this.companyName = companyName
    }


    fun getCompanySize(): CompanySize?{

        return this.companySize

    }

    fun setCompanySize(companySize: CompanySize){
        this.companySize = companySize
    }

    fun getCompanyAddress(): List<CompanyAddress>?{
        return this.companyAddress
    }

    fun getTaxRegistrationNum(): String? {
        return this.taxRegistrationNumber
    }

    fun setTaxRegistrationNum(trn: String){
        this.taxRegistrationNumber = trn
    }



}