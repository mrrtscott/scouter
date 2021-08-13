import { Link, useLocation, useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import Nav from '../../components/Nav';
export default function SelectedApplicants() {
  const location = useLocation();
  const { applicants } = location.state;

  const [acceptedApplicants, setAcceptedApplicants] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await fetch(
          `https://scouter.point876solutions.com/application/selected-applicants/1`
        );
        const json = await response.json();
        setAcceptedApplicants(json);
      } catch (e) {
        console.error(e);
      }
    }
    fetchData();
  }, []);

  return (
    <div className="flex flex-col w-full h-screen overflow-x-hidden overflow-y-hidden">
      <Nav />
      <div className="h-full overflow-x-auto">
        <div className="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
          <div className="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
            <table className="min-w-full divide-y divide-gray-200">
              <thead className="bg-gray-50">
                <tr>
                  <th
                    scope="col"
                    className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                  >
                    Name
                  </th>
                  <th
                    scope="col"
                    className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                  >
                    Submitted
                  </th>
                  <th
                    scope="col"
                    className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                  >
                    Status
                  </th>
                  <th
                    scope="col"
                    className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                  >
                    Skills
                  </th>
                  <th scope="col" className="relative px-6 py-3">
                    <span className="sr-only">Edit</span>
                  </th>
                </tr>
              </thead>
              <tbody
                className="bg-white divide-y divide-gray-200 overflow-y-scroll"
                style={{ height: '40vh' }}
              >
                {applicants.map((applicant, index) => (
                  <tr key={index}>
                    <td className="px-6 py-4 whitespace-nowrap">
                      <div className="flex items-center">
                        <div className="flex-shrink-0 h-10 w-10">
                          <img
                            className="h-10 w-10 rounded-full"
                            src="https://randomuser.me/api/portraits/women/24.jpg"
                            alt=""
                          />
                        </div>
                        <div className="ml-4">
                          <div className="text-sm font-medium text-gray-900">
                            {applicant.firstName} {applicant.lastName}
                          </div>
                          <div className="text-sm text-gray-500">
                            TRN: {applicant.taxRegistrationNumber}
                          </div>
                        </div>
                      </div>
                    </td>
                    <td className="px-6 py-4 whitespace-nowrap">
                      <div className="text-sm text-gray-900">
                        {applicant.updatedAt.slice(0, 10)}
                      </div>
                    </td>

                    <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                      <span className="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-yellow-100 text-yellow-800">
                        {applicant.applicantStatus}
                      </span>
                    </td>
                    <td className="px-6 py-4 whitespace-nowrap w-96 overflow-x-scroll">
                      {applicant.skillList.map(function (skill, index) {
                        return (
                          <span className="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-blue-100 text-blue-800 mr-2">
                            {skill}
                          </span>
                        );
                      })}
                    </td>
                    <td className="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                      <a
                        href="#"
                        className="text-indigo-600 hover:text-indigo-900"
                      >
                        Edit
                      </a>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>

      {acceptedApplicants.length > 0 && (
        <div className="h-2/4 px-6 mt-4">
          <h3 className=" text-gray-900 font-semibold text-lg mt-6 mb-3">
            Accepted Applicants
          </h3>
          <table class="w-full sortable">
            <thead class="w-full flex justify-between">
              <tr class="flex w-full justify-between text-md font-semibold tracking-wide text-left text-gray-900 bg-gray-100 uppercase  border-gray-600">
                <th class="px-4 py-3 cursor-pointer w-2/5">Name</th>
                <th class="px-4 py-3 w-1/4">TRN</th>
                <th class="px-4 py-3 w-1/4">Education</th>
                <th class="px-4 py-3 cursor-pointer w-1/4">Status</th>
              </tr>
            </thead>
            <tbody
              className="flex w-full justify-between  flex-col overflow-y-scroll"
              style={{ height: '65vh' }}
            >
              {acceptedApplicants.map(function (applicant, index) {
                return (
                  <tr
                    key={index}
                    class="text-gray-700 flex w-full justify-between"
                  >
                    <td
                      class="px-4 w-2/5 py-3"
                      style={{ borderWidth: '0.5px' }}
                    >
                      <div class="flex items-center text-sm">
                        <div class="relative w-8 h-8 mr-3 rounded-full md:block">
                          <img
                            class="object-cover w-full h-full rounded-full"
                            src="https://i.pravatar.cc/24"
                            alt=""
                            loading="lazy"
                          />
                          <div
                            class="absolute inset-0 rounded-full shadow-inner"
                            aria-hidden="true"
                          ></div>
                        </div>
                        <div>
                          <p class="font-semibold text-black">
                            {applicant.firstName} {applicant.lastName}
                          </p>
                          <p class="text-xs text-gray-600 lowercase">
                            Pending employment
                          </p>
                        </div>
                      </div>
                    </td>
                    <td
                      class="px-4 w-1/4 py-3 text-ms font-semibold"
                      style={{ borderWidth: '0.5px' }}
                    >
                      {applicant.taxRegistrationNumber}
                    </td>
                    <td
                      class="px-4 w-1/4 py-3 text-xs"
                      style={{ borderWidth: '0.5px' }}
                    >
                      {applicant.eductionProfile.listOfEducation.map(function (
                        education,
                        index
                      ) {
                        return (
                          <span
                            key={index}
                            className="px-2 py-1 font-semibold leading-tight text-blue-700 bg-blue-100 rounded-sm"
                          >
                            {education.attainment}
                          </span>
                        );
                      })}
                    </td>
                    <td
                      class="px-4 w-1/4 py-3 text-sm"
                      style={{ borderWidth: '0.5px' }}
                    >
                      <span className="px-2 py-1 font-semibold leading-tight text-green-700 bg-green-100 rounded-sm">
                        Accepted
                      </span>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}
