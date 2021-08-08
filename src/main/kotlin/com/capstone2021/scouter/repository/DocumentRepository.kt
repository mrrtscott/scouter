package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.Documents
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DocumentRepository: JpaRepository<Documents, Long> {

}