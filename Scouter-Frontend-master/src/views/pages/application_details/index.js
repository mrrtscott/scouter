import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import CompanyDetails from './components/company_details';
import ApplicationDetails from './components/application_details';
import Stages from './components/stages';
import Enquiries from './components/enquiries';
import JobDetails from './components/job_details';
import EduRequirements from './components/edu_requirements';
import SkillRequirements from './components/skill_requirements';
import EmploymentRequirements from './components/emp_requirements';
import DocumentList from './components/document_list';
import { AppHeader } from '../../components/AppHeader';
import { AppFooter } from '../../components/AppFooter';

export default function ApplicationDetailsPage() {
  const { id } = useParams();

  const [{ company, jobApplication }, setData] = useState({});

  const address = company && company.companyAddress[0];
  const job = jobApplication && jobApplication.job;

  useEffect(() => {
    axios
      .get(
        `https://scouter.point876solutions.com/application/get-details/${id}`
      )
      .then((resp) => resp.data)
      .then((data) => {
        const [company, jobApplication] = data;

        setData({ company, jobApplication });
      })
      .catch((err) => console.log(err));
  }, [id]);

  return (
    <>
      <AppHeader></AppHeader>
      {!company && 'Loading'}
      {company && (
        <div className="container mx-auto py-6">
          <h2 className={'text-3xl font-semibold text-gray-600 mb-8'}>
            Application Details
          </h2>

          <div className={'flex gap-3'}>
            <div className="w-1/2 space-y-3">
              {/* company details */}
              <CompanyDetails company={company} address={address} />

              {/* application details */}
              <ApplicationDetails jobApplication={jobApplication} />

              {/* Stages  */}
              <Stages job={job} jobApplication={jobApplication} />

              {/* enquiries */}
              <Enquiries jobApplication={jobApplication} />
            </div>

            <div className="w-1/2 space-y-3">
              {/* job details  */}
              <JobDetails job={job} />

              {/* Education requirements */}
              <EduRequirements job={job} />

              {/* Skill requirements */}
              <SkillRequirements job={job} />

              {/* Employment requirements */}
              <EmploymentRequirements job={job} />

              {/* document list */}
              <DocumentList jobApplication={jobApplication} />
            </div>
          </div>
        </div>
      )}
      <AppFooter></AppFooter>
    </>
  );
}
