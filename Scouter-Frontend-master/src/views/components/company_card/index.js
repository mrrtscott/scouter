import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

export default function CompanyCard({ company }) {
  return (
    <div className="flex flex-col container mx-auto p-4 max-w-sm rounded-md overflow-hidden shadow-xl hover:shadow-2xl transition duration-300 items-center justify-center">
      <div className="flex items-center justify-center mb-6">
        <img className=" w-20 h-auto" src={company.logo} alt="" />
        <h1 className="ml-1 text-center text-lg text-gray-900 font-semibold">
          {company.companyName}
        </h1>
      </div>
      <div className="flex flex-col justify-start w-full items-center">
        <div className=" mb-6">
          <a href={company.website} className="mt-2">
            {company.website}
          </a>
        </div>
        <div>
          <Link
            to={{
              pathname: `/company-details/${company.id}`,
            }}
          >
            <button className="w-max text-white text-md font-semibold bg-green-400 py-1 px-4 rounded-lg shadow-md hover:shadow-lg transition duration-500 transform-gpu hover:scale-110 ">
              More details
            </button>
          </Link>
        </div>
      </div>
    </div>
  );
}
