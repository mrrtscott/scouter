//interfactes
/*interface CompanyUser {
    companyName: String,
    companyEmail: String,
    companyContactFirstName: String,
    companyContactLastName: String,
    companyAddress?: String
}*/


//signup functions
export const signupAsRecruiter = () => {
    console.log('signup as recruiter clicked');
}

export const signupAsApplicant = () => {
    console.log('signup as applicant clicked');
}

//loginfunctions
export const isAuthenticated = () => {
    loginAsApplicant();
    return true;
}
export const loginAsApplicant = () => {
    const user = {
        userName: 'jessicaj',
        firstName: 'Jessica',
        lastName: 'James',

    }

    localStorage.setItem('applicantUser', user);
    return user;
}

export const loginAsRecruiter = () => {
    const user = {
        companyName: 'MuffetEnterprises',
        companyEmail: 'muffetenterprises@gmail.com',
        firstName: 'Sherica',
        lastName: 'Jackson',
        companyAddress: '124 Slipe Road, Off CrossRoads, Kingston 2'
    }

    localStorage.set('companyUser', user);
    return user;
}