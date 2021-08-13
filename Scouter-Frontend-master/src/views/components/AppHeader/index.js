import React, { useState } from 'react';
//import './style.css';
import bell from '../../../images/bell.svg';
import logo from '../../../images/Logo.svg';
import {
  loginAsRecruiter,
  loginAsApplicant,
  isAuthenticated,
} from '../../../api/home-api';
import { Link } from 'react-router-dom';

export const AppHeader = () => {
  const [currentUser, setCurrentUser] = useState();

  const getLoginModal = () => {
    let state = { email: '', password: '' };

    const handleChange = (name, value) => {
      this.setState({ ...state, [name]: value });
    };

    const loginUser = () => {
      setCurrentUser({
        userName: 'jessicaj',
        firstName: 'Jessica',
        lastName: 'James',
        token:
          'sdlkdslkklsew90jkljf88432WE$#$%RY^WEWSE#$%$%$%TERGEWDWE@#@$#$#RRG$REFREDF',
      });
    };

    return (
      <div className="authModal">
        <input
          type="email"
          label="Email address"
          icon="email"
          value={this.state.email}
          onChange={handleChange.bind(this, 'email')}
        />
        <input
          type="password"
          label="Password"
          name="password"
          icon="password"
          value={this.state.password}
          onChange={this.handleChange.bind(this, 'phone')}
        />
        <button type="submit" onClick={loginUser('recruiter')}>
          Login
        </button>
      </div>
    );
  };

  const getLeftHeader = () => {
    console.log(currentUser);
    return isAuthenticated() ? (
      <div className="flex h-full px-2 py-1 justify-center w-max">
        <Link to={`/jobs/4`}>
          <div className="mx-3 h-full hover:bg-gray-200 cursor:pointer">
            Dashboard
          </div>
        </Link>
        <Link to={`/applications-list/3`}>
          <div className="mx-3 h-full hover:bg-gray-200 cursor:pointer">
            Submitted
          </div>
        </Link>
        <img className="h-6 w-auto" src={bell} alt="Bell Icon"></img>
        <h3 className="px-2">Shericka Jackson</h3>
      </div>
    ) : (
      <div className="flex justify-center w-max">
        <img className="h-6 w-auto" src={bell} alt="Bell Icon"></img>
        <button className="px-2">Signup</button>
        <button className="px-2" onClick={getLoginModal()}>
          Login
        </button>
      </div>
    );
  };

  return (
    <div>
      <nav className="flex w-full bg-white justify-between items-center p-4">
        <img src={logo} alt="Scouter Logo"></img>
        {getLeftHeader()}
      </nav>
    </div>
  );
};
