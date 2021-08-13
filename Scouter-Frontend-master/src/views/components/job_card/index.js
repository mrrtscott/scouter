import axios from 'axios';
import React from 'react';

import AddressCard from '../address_card';

export default function JobCard({ job, applicantId }) {
  const baseUrl = 'https://scouter.point876solutions.com';

  const { company, jobPosting } = job;

  const applyForJob = () => {
    axios
      .post(
        `https://scouter.point876solutions.com/application?applicantId=${applicantId}&companyId=${company.id}&jobPostId=${jobPosting.id}`
      )
      .then((resp) => {
        alert('Applied successfully.');
      })
      .catch((err) => console.log(err));
  };

  return (
    <div className="job_card border bg-white rounded p-6 m-6">
      <div className={'flex gap-8 justify-between items-center'}>
        <div className="logo w-36 h-36 rounded-lg shadow flex items-center justify-center p-1 ">
          <a href={`${baseUrl}/company/${company.id}`}>
            <img src={company.logo} alt="company-logo" />
          </a>
        </div>

        <div>
          <div className="font-semibold text-lg text-blue-600">
            <a href={`${baseUrl}/company/${company.id}`}>
              {company.companyName}
            </a>
          </div>

          <div className="address">
            {company.companyAddress.length > 0 && (
              <AddressCard address={company.companyAddress[0]} />
            )}
          </div>

          <div className="text-blue-600">
            <a href={company.website}>{company.website}</a>
          </div>
        </div>
      </div>

      <div>
        <div className="job_info">
          <div className="desc mb-5">
            <p className={'text-lg font-semibold'}>Description: </p>
            <p>{jobPosting.description}</p>
          </div>

          <div className="position mb-5">
            <p className={'text-lg font-semibold'}>Postion: </p>
            <p>{jobPosting.position}</p>
          </div>

          <div className="emp_type mb-5">
            <p className={'text-lg font-semibold'}>Employment Type: </p>

            <p>{jobPosting.employmentType}</p>
          </div>
        </div>

        <div className="space-y-3 justify-between">
          <a
            className="text-indigo-600 w-full block text-center  border border-indigo-600 rounded p-2 shadow hover:bg-indigo-700 hover:text-white hover:shadow-lg"
            href={`${baseUrl}/jobPosting/${jobPosting.id}`}
          >
            View more
          </a>

          <button
            className="bg-indigo-600 w-full block text-center text-white rounded p-2 shadow hover:bg-indigo-700 hover:shadow-lg"
            onClick={applyForJob}
          >
            Apply Now
          </button>
        </div>
      </div>
    </div>
  );
}
