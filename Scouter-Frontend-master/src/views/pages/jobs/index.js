import JobCard from '../../components/job_card';
import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { AppHeader } from '../../components/AppHeader';
import { AppFooter } from '../../components/AppFooter';
function JobsPage() {
  const [jobs, setJobs] = useState([]);
  const { applicantId } = useParams();

  useEffect(() => {
    fetch(
      `https://scouter.point876solutions.com/applicant/dashboard/${applicantId}`
    )
      .then((resp) => resp.json())
      .then((data) => (Array.isArray(data) ? setJobs(data) : ''))
      .catch((err) => console.log(err));
  }, [applicantId]);

  return (
    <div className="">
      <AppHeader></AppHeader>
      <div className={'grid grid-col grid-cols-3 grid-flow-row h-full gap-4'}>
        {jobs.map((job, idx) => {
          return <JobCard job={job} key={idx} applicantId={applicantId} />;
        })}
      </div>
      <AppFooter></AppFooter>
    </div>
  );
}

export default JobsPage;
