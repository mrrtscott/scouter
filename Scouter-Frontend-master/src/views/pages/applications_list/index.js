import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import ApplicationCard from '../../components/application_card';
import { getApplicationDetails } from '../../../network';
import { AppHeader } from '../../components/AppHeader';

export default function ApplicationsListPage() {
  const { personId } = useParams();

  const [applications, setApplications] = useState([]);

  useEffect(() => {
    getApplicationDetails(personId)
      .then((resp) => resp.data)
      .then((data) => setApplications(data))
      .catch((err) => console.log(err));
  }, [personId]);

  return (
    <>
      <AppHeader></AppHeader>
      <div className={'container mx-auto py-6 space-y-4'}>
        <h2 className={'text-2xl font-semibold text-gray-600 mb-6'}>
          List of Applications
        </h2>
        <div className="grid grid-col grid-cols-3 grid-flow-row gap-4">
          {applications.map((application) => {
            return (
              <ApplicationCard
                key={application.dateCreated}
                application={application}
              />
            );
          })}
        </div>
      </div>
    </>
  );
}
