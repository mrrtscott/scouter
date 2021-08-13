import axios from 'axios';

const randomJob = {
  description: 'Working in the tax department of TLS',
  position: 'Technology Support I',
  employmentType: 'FULL_TIME',
  duration: 36,
  basicYearlySalary: 7400000,
  minAge: 18,
  maxAge: 60,
  educationRequirements: [
    {
      description: 'Applicant must have a first degree',
      requiredAttainment: 'BACHELOR',
    },
  ],
  employmentRequirements: [
    {
      minYearsExperience: 1,
      experiencePosition: 'Programmer',
    },
  ],
  skillRequirements: [
    {
      description: 'Tax analysis',
      skill: 'Tax analysis',
      isRequired: 'True',
    },
    {
      description: 'Sage',
      skill: 'Sage',
      isRequired: 'False',
    },
  ],
  stages: [
    {
      stageName: 'First Interview',
      stageDescription:
        'At this stage we will ask you basic things about yourself and ambitions',
      stageComponent: [
        {
          name: 'Interview',
          details: 'Please use the box in your profile to continue',
          requiredDate: '2021-08-04T08:00:00.0Z',
          endDate: '2021-08-04T09:00:00.0Z',
        },
      ],
      isRequired: true,
    },
    {
      stageName: 'Quiz',
      stageDescription: 'This psychometric quiz is available here',
      stageComponent: [
        {
          name: 'Quiz',
          details: 'Please do this quiz',
          requiredDate: '2021-08-04T10:00:00.0Z',
          endDate: '2021-08-04T11:30:00.0Z',
        },
      ],
      isRequired: true,
    },
  ],
};

const randomCompany = {};

export function getCompanies() {
  return axios.get('https://scouter.point876solutions.com/company');
}

export function getCompanyDetails(id) {
  return axios.get(`https://scouter.point876solutions.com/company/${id}`);
}

export function getApplicants(id) {
  return axios.get(
    `https://scouter.point876solutions.com/application/get-applicants-per-job?job=${id}&status=ALL`
  );
}

export function postJob(company, values) {
  return axios
    .post(`https://scouter.point876solutions.com/jobPosting/${company}`, values)
    .then((resp) => resp.data);
}

export function addCompany(values) {
  // return axios.post("http://scouter.point876solutions.com/company", values)
  //     .then(resp => resp.data)

  return axios({
    method: 'POST',
    url: 'https://scouter.point876solutions.com/company',
    data: values,
  }).then((resp) => resp.data);
}

export function getApplicationDetails(personId) {
  return axios.get(
    `https://scouter.point876solutions.com/application/${personId}?type=applications`
  );
}

export function uploadDocument(file, applicantId, applicationId) {
  const data = new FormData();
  data.append('files', file);

  return axios.post(
    `https://scouter.point876solutions.com/document/upload-files/${applicantId}/${applicationId}`,
    data,
    {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    }
  );
}
