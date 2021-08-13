import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { BrowserHistory } from 'react-router';
import { getCompanyDetails } from '../../../network';
import { FaAngleLeft as Back } from 'react-icons/fa';
import { MdEmail, MdWeb } from 'react-icons/md';
import Nav from '../../components/Nav';

export default function CompanyDetails() {
  const params = useParams();
  const [company, setCompany] = useState({});

  useEffect(() => {
    getCompanyDetails(params.id)
      .then((resp) => resp.data)
      .then((data) => setCompany(data))
      .catch((err) => console.log(err));
  }, []);

  return (
    <>
      <Nav />
      {company.companyName !== undefined ? (
        <div className={'container mx-auto py-6'}>
          <div className="flex items-center justify-between ">
            <Link to={`/companies`}>
              <div className="cursor-pointer flex items-center">
                <Back />
                <p>Back</p>
              </div>
            </Link>
            <Link to={`/job-posting/${company.id}`}>
              <button
                className={
                  'p-2 font-semibold text-white bg-green-600 hover:bg-green-700 shadow-lg hover:shadow rounded ml-auto block'
                }
              >
                Create Job Posting
              </button>
            </Link>
          </div>
          <div className="flex items-center bg-white mt-8">
            <div className={'w-80 bg-white rounded shadow p-8'}>
              <img src={company.logo} alt="" className={'w-full'} />
            </div>

            <div className={'ml-16 w-full bg-white p-8 rounded'}>
              <p className={'text-2xl font-semibold text-gray-600'}>
                {company.companyName}
              </p>

              <div className={'mt-6'}>
                <h2 className={'font-semibold text-lg underline text-gray-600'}>
                  Addresses
                </h2>

                <div
                  className={
                    ' mt-2 flex justify-between text-gray-500 font-medium'
                  }
                >
                  {company.companyAddress &&
                    company.companyAddress.map((address, idx) => {
                      return (
                        <div key={idx}>
                          <p>
                            {address.streetNumber}, {address.streetName}{' '}
                          </p>
                          <p>{address.city}</p>
                          <p>{address.country}</p>
                        </div>
                      );
                    })}
                </div>
              </div>
            </div>
          </div>

          <h2 className={'text-xl text-gray-700 font-semibold mt-6'}>
            More details:
          </h2>

          <div className={'mt-4'}>
            <p className={'flex'}>
              <MdEmail size={25} className={'mr-4'} />
              <a href={`mailto:${company.email}`}>{company.email}</a>
            </p>

            <p className={'flex'}>
              <MdWeb size={25} className={'mr-4'} />
              <a href={`${company.website}`}>{company.website}</a>
            </p>
          </div>
        </div>
      ) : (
        <div>loading... </div>
      )}
    </>
  );
}
