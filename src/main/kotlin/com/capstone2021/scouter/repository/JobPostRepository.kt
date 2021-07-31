package com.capstone2021.scouter.repository

import com.capstone2021.scouter.model.JobPosting
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JobPostRepository : JpaRepository <JobPosting, Long> {




}