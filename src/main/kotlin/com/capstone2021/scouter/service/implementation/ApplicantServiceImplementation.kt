package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.algorithms.Functions
import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.CompanyJobPosting
import com.capstone2021.scouter.model.JobPosting
import com.capstone2021.scouter.repository.ApplicantRepository
import com.capstone2021.scouter.repository.CompanyRepository
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
    lateinit var  companyRepository:CompanyRepository

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

    override fun getQualifiedJobs(applicant: Applicant):MutableList<CompanyJobPosting>? {
        var allPostedJobs: MutableList<JobPosting> = jobRepository.findAll()
        var outputList = mutableListOf<JobPosting>()
        var finalOutput: MutableList<CompanyJobPosting> = mutableListOf()
        System.out.println("Number of jobs: " +  allPostedJobs.count())
        var set: MutableList<Int> = mutableListOf()


        var jobCount = -1

        for (job in allPostedJobs){
            var skillCount = 0
            jobCount+=1
            System.out.println(job.getDescription())
            if(functions.getAge(applicant.getDateOfBirth()) < (job.getMinAge() ?: 0)){
                println("true: Age less")
                set?.add(jobCount)

            }
            if(functions.getAge(applicant.getDateOfBirth()) > (job.getMaxAge() ?: 0)){

                System.out.println("true: Age more")
                set?.add(jobCount)
            }



             if(job.getBasicYearlySalary()!!.toDouble() < applicant?.getProspectiveJob()?.getMinimumSalary()!!){
                System.out.println("true: Minimum Salary " + job.getBasicYearlySalary()!! + " " + applicant.getProspectiveJob()?.getMinimumSalary()!!)
                set!!.add(jobCount)
            }

            //Check education requirement


            if(!functions.matcher(job.getPosition().toString().lowercase(Locale.getDefault()), applicant.getProspectiveJob()?.getPosition())){

//

                System.out.println(functions.matcher(job.getPosition().toString().lowercase(Locale.getDefault()), applicant.getProspectiveJob()?.getPosition()))
                System.out.println("true: Job Position does not match")
                set?.add(jobCount)


            }


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
            System.out.println("Skill Count" + skillCount)

            if (skillCount == 0){
                set?.add(jobCount)

            }


        }

        if (set != null) {
            var distinct:List<Int> = set.toSet().toList()
            var subList:MutableList<JobPosting> = mutableListOf()
            for(i in distinct){
                subList.add(allPostedJobs[i])
            }
            outputList = allPostedJobs.minus(subList) as MutableList<JobPosting>


            for( j in outputList){
                System.out.println("Job Id: " + j.getId())
                var company = j.getId()?.let { companyRepository.getCompanyByJobPostId(it) }
                company?.removeAllJobPost()
                var companyJobPost = CompanyJobPosting(company , j)

                if(finalOutput.add(companyJobPost)){
                    println("added")
                }



            }
        }

        System.out.println("Posted Job " + outputList.count())
        return finalOutput

    }

}