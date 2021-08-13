import './App.css';
import AdminHome from './views/pages/admin_home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import { useState, useEffect } from 'react';
import { getCompanies } from './network';
import JobsPage from './views/pages/jobs';
import CompaniesPage from './views/pages/companies';
import CompanyDetails from './views/pages/company_details';
import PostingPage from './views/pages/posting';
import AddCompanyPage from './views/pages/add_company';
import ApplicationsListPage from './views/pages/applications_list';
import ApplicationDetailsPage from './views/pages/application_details';
import SelectedApplicants from './views/pages/selected_applicants';
import Home from './views/pages/home';
import ApplicantSignup from './views/pages/applicant-signup';
function App() {
  const [companies, setCompanies] = useState([]);

  // get companies
  useEffect(() => {
    getCompanies()
      .then((resp) => resp.data)
      .then((data) => setCompanies(data))
      .catch((err) => console.log(err));
  }, []);

  return (
    <Router>
      <Switch>
        <Route path={'/admin'}>
          <AdminHome />
        </Route>

        <Route path={'/jobs/:applicantId'}>
          <JobsPage />
        </Route>
        <Route path={'/applicant'}>
          <ApplicantSignup />
        </Route>

        <Route path={'/companies'}>
          <CompaniesPage companies={companies} />
        </Route>

        <Route path={'/company-details/:id'}>
          <CompanyDetails />
        </Route>

        <Route path={'/job-posting/:id'}>
          <PostingPage />
        </Route>

        <Route path={'/add-company'}>
          <AddCompanyPage />
        </Route>

        <Route path={'/applications-list/:personId'}>
          <ApplicationsListPage />
        </Route>

        <Route path={'/application-details/:id'}>
          <ApplicationDetailsPage />
        </Route>

        <Route path={'/selected-applicants/:id'}>
          <SelectedApplicants />
        </Route>
        <Route path={'/recruiters'}>
          <Home />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
