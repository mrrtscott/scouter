import React from 'react';
//import { HomeInfoComponent } from '../../components/HomeInfoComponent/index';
//import * as api from '../../../api/home-api';


///render top level errors, warning and info as banner or modal

export const Home = () => {
    return (
        <div class="home w-10 h-screen">
            <div class="banner" id="banner">
                |<div class="slogan">Find your perfect fit</div>
                <div class="slogan-subtitle">Scouter takes the tedious out of recruitment from start to finish.</div>
            </div>
            <div class="home-cta-container">
                {/*   <HomeInfoComponent
                    title="Find great talent"
                    subtitle="It's time to stop worrying about filtering unqualified and uninterested talent. Join Scouter today!"
                    ctaText="Start Recruiting"
                    ctaAction={api.signupAsRecruiter()}
                />
                <HomeInfoComponent
                    title="Find great jobs"
                    subtitle="It's time to stop worrying about filtering through job applications that don't match your skillset.!"
                    ctaText="Start Finding Jobs"
                    ctaAction={api.signupAsApplicant()}
             />*/}
            </div>
        </div>
    );
}