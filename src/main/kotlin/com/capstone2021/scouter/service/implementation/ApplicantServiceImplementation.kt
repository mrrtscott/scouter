package com.capstone2021.scouter.service.implementation

import com.capstone2021.scouter.algorithms.Functions
import com.capstone2021.scouter.model.Applicant
import com.capstone2021.scouter.model.ApplicantRadar
import com.capstone2021.scouter.model.CompanyJobPosting
import com.capstone2021.scouter.model.JobPosting
import com.capstone2021.scouter.model.enum.BucketName
import com.capstone2021.scouter.repository.ApplicantRepository
import com.capstone2021.scouter.repository.CompanyRepository
import com.capstone2021.scouter.repository.JobPostRepository
import com.capstone2021.scouter.service.ApplicantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
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

    @Autowired
    lateinit var fileStorage: FileStorageImplementationService

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

    override fun getTwoApplicantsWithJob(
        applicant1: Long,
        applicant2: Long,
        job: Long
    ): MutableList<ApplicantRadar> {
        var activeJob = jobRepository.findById(job).get()
        var result:MutableList<ApplicantRadar> = mutableListOf()
        var applicantList = applicantRepository.getSpecificApplicants(applicant1, applicant2)
        for (eachApplicant in applicantList){
            var cumulativeJobExperience = 0
            var numberOfSkillsMatched = 0
            var numberOfEducationAttainment = 0

            var jobSkill = activeJob.getSkillRequirements()

            //Calculating how many skills matched
            if (jobSkill != null) {
                for (skill in jobSkill){
                    for (applicantSkill in eachApplicant.getSkillList()){
                        if(functions.matcher(skill.getSkill(), applicantSkill)){
                            numberOfSkillsMatched+=1
                        }
                    }

                }

            }

            numberOfEducationAttainment = eachApplicant.getEductionProfile()?.getListOfEducation()?.count()!!.toInt()

            var jobExperiences = eachApplicant.getEmploymentProfile()?.getListOfEmployment()
            if (jobExperiences != null) {
                for(jobExperience in jobExperiences){
                    cumulativeJobExperience+=functions.monthsBetween(jobExperience.getEmploymentStartDate(), jobExperience.getEmploymentEndDate())
                }
            }

            var applicantRadar = ApplicantRadar(eachApplicant,numberOfSkillsMatched, numberOfEducationAttainment)
            result.add(applicantRadar)




        }
        return result
    }

    override fun addProfileImage(applicant: Long, file: MultipartFile) {
        functions.isFileEmpty(file)
        functions.isImage(file)
        var activeApplicant = applicantRepository.getById(applicant)
        var metadata: Map<String?, String?> = functions.extractMetadata(file)
        var path = java.lang.String.format("%s/%s", BucketName.DOCUMENTS_AWS.bucketName, activeApplicant.getId())
        val filename = java.lang.String.format("%s-%s", UUID.randomUUID(), file.originalFilename)

        try {
            fileStorage.save(path, filename, Optional.of(metadata), file.inputStream)
            activeApplicant.setPhotoUrl(filename)
            applicantRepository.save(activeApplicant)
        } catch (e: IOException) {
            throw IllegalStateException(e)
        }

    }


}