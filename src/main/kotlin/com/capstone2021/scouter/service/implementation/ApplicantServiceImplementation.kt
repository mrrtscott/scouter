package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.algorithms.Functions
import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.JobPosting
import com.capstone2021.scouter.repository.ApplicantRepository
import com.capstone2021.scouter.repository.JobPostRepository
import com.capstone2021.scouter.service.ApplicantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class ApplicantServiceImplementation : ApplicantService {

    var functions = Functions()

    @Autowired
    lateinit var applicantRepository: ApplicantRepository

    @Autowired
    lateinit var jobRepository: JobPostRepository

    override fun saveApplicant(applicant: Applicant) {
        applicantRepository.save(applicant)
    }

    override fun findAllApplicants(): List<Applicant>? {
        return applicantRepository.findAll()
    }

    override fun findApplicant(id: Long): Applicant? {
        return applicantRepository.getById(id)
    }

    override fun countApplicant(): Long {
        return applicantRepository.count()
    }

    override fun getTwoApplicant(applicant1: Long, applicant2: Long):List<Applicant> {
        return applicantRepository.getSpecificApplicants(applicant1, applicant2)
    }

    override fun getQualifiedJobs(applicant: Applicant):List<JobPosting>? {
        var allPostedJobs: MutableList<JobPosting> = jobRepository.findAll()

        for (job in allPostedJobs){
            if(functions.getAge(applicant.getDateOfBirth()) < job.getMinAge()!!.toInt()){
                allPostedJobs.remove(job)
                continue
            }
            if(functions.getAge(applicant.getDateOfBirth()) > job.getMaxAge()!!.toInt()){
                allPostedJobs.remove(job)
                continue
            }

            if(job.getBasicYearlySalary()!! < applicant.getProspectiveJob()?.getMinimumSalary()!!){
                allPostedJobs.remove(job)
                continue
            }


            if(!functions.matcher(job.getPosition().toString().lowercase(Locale.getDefault()), applicant.getProspectiveJob().toString())){
                allPostedJobs.remove(job)
                continue
            }

            var skillCount = 0
            var jobPostingSkills = job.getSkillRequirements()

            if (jobPostingSkills != null) {
                for (skill in jobPostingSkills){
                    for (applicantSkill in applicant.getSkillList()){
                        if(functions.matcher(skill.getSkill(), applicantSkill)){
                            skillCount+=1
                        }
                    }

                }

            }
            println(skillCount)

            if (skillCount == 0){
                allPostedJobs.remove(job)
                continue

            }


        }

        return allPostedJobs

    }

}