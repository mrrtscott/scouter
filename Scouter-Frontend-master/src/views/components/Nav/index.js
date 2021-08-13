import { React, useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import logo from '../../../images/Logo.svg';
import bell from '../../../images/bell.svg';
const Nav = () => {
  const [menuOpen, setmenuOpen] = useState('hidden');
  return (
    <nav className=" px-5 w-screen h-12 bg-white relative top-0 left-0 flex justify-start">
      <Link to={{ pathname: `/admin` }}>
        <img className="px-2 py-2" src={logo} />
      </Link>
      <div className="flex  flex-grow px-2 justify-end items-center">
        <img
          className="w-5 h-5 cursor-pointer hover:scale-110 transform transition-all duration-500 ease-in-out"
          src={bell}
        ></img>
        <div className="w-0.5 ml-4 h-2/4 bg-black"></div>
        <Link
          to={{
            pathname: `/companies`,
          }}
        >
          <div className="mx-4 rounded-b-sm cursor-pointer transition-colors duration-500 ease-in-out hover:bg-gray-200 border-b-4 border-white w-max p-4">
            <p className="text-sm font-medium text-gray-800 leading-none">
              Companies
            </p>
          </div>
        </Link>
        <img
          onClick={() =>
            setmenuOpen(menuOpen == 'hidden' ? 'visible' : 'hidden')
          }
          className="w-8 h-8s rounded-full cursor-pointer hover:border-green-600 border-transparent border-4 transition-all duration-500 ease-in-out"
          src="https://randomuser.me/api/portraits/women/24.jpg"
        ></img>
      </div>

      <div className={`${menuOpen} z-50 my-10 absolute top-0 right-2`}>
        <div className="bg-white rounded overflow-hidden shadow-lg">
          <div className="text-center p-6  border-b">
            <img
              className="h-24 w-24 rounded-full mx-auto"
              src="https://randomuser.me/api/portraits/women/24.jpg"
              alt="Randy Robertson"
            />
            <p className="pt-2 text-lg font-semibold">Alexis Brown</p>
            <p className="text-sm text-gray-600">alexis.brown@scouter.com</p>
            <div className="mt-5">
              <a
                href="#"
                className="border rounded-full py-2 px-4 text-xs font-semibold text-gray-700"
              >
                Manage your Account
              </a>
            </div>
          </div>
          <div className="border-b">
            <a href="#" className="px-4 py-2 hover:bg-gray-100 flex">
              <div className="text-gray-800">
                <svg
                  fill="none"
                  stroke="currentColor"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="1"
                  viewBox="0 0 24 24"
                  className="w-5 h-5"
                >
                  <path d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
                </svg>
              </div>
              <div className="pl-3">
                <Link to={`/add-company`}>
                  <p className="text-sm font-medium text-gray-800 leading-none">
                    Add Company
                  </p>
                </Link>
                <p className="text-xs text-gray-500">
                  Add/manage users &amp; teams
                </p>
              </div>
            </a>
            <a href="#" className="px-4 py-2 hover:bg-gray-100 flex">
              <div className="text-gray-800">
                <svg
                  fill="none"
                  stroke="currentColor"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="1"
                  viewBox="0 0 24 24"
                  className="w-5 h-5"
                >
                  <path d="M10.325 4.317c.426-1.756 2.924-1.756 3.35 0a1.724 1.724 0 002.573 1.066c1.543-.94 3.31.826 2.37 2.37a1.724 1.724 0 001.065 2.572c1.756.426 1.756 2.924 0 3.35a1.724 1.724 0 00-1.066 2.573c.94 1.543-.826 3.31-2.37 2.37a1.724 1.724 0 00-2.572 1.065c-.426 1.756-2.924 1.756-3.35 0a1.724 1.724 0 00-2.573-1.066c-1.543.94-3.31-.826-2.37-2.37a1.724 1.724 0 00-1.065-2.572c-1.756-.426-1.756-2.924 0-3.35a1.724 1.724 0 001.066-2.573c-.94-1.543.826-3.31 2.37-2.37.996.608 2.296.07 2.572-1.065z" />
                  <path d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                </svg>
              </div>
              <div className="pl-3">
                <p className="text-sm font-medium text-gray-800 leading-none">
                  Account settings
                </p>
                <p className="text-xs text-gray-500">
                  Usage, billing, branding, teams
                </p>
              </div>
            </a>
            <a href="#" className="px-4 py-2 hover:bg-gray-100 flex">
              <div className="text-gray-800">
                <svg
                  fill="none"
                  stroke="currentColor"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="1"
                  viewBox="0 0 24 24"
                  className="w-5 h-5"
                >
                  <path d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
                </svg>
              </div>
              <div className="pl-3">
                <p className="text-sm font-medium text-gray-800 leading-none">
                  Personal settings
                </p>
                <p className="text-xs text-gray-500">
                  Email, profile, notifications
                </p>
              </div>
            </a>
            <a href="#" className="px-4 py-2 hover:bg-gray-100 flex">
              <div className="text-green-600">
                <svg
                  fill="none"
                  stroke="currentColor"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="1"
                  viewBox="0 0 24 24"
                  className="w-5 h-5"
                >
                  <path d="M5 3v4M3 5h4M6 17v4m-2-2h4m5-16l2.286 6.857L21 12l-5.714 2.143L13 21l-2.286-6.857L5 12l5.714-2.143L13 3z" />
                </svg>
              </div>
              <div className="pl-3">
                <p className="text-sm font-medium text-gray-800 leading-none">
                  Apps &amp; integrations
                </p>
                <p className="text-xs text-gray-500">Google, slack, mail</p>
              </div>
            </a>
          </div>

          <div className="">
            <a href="#" className="px-4 py-2 pb-4 hover:bg-gray-100 flex">
              <p className="text-sm font-medium text-gray-800 leading-none">
                Product updates
              </p>
            </a>
            <a href="#" className="px-4 py-2 pb-4 hover:bg-gray-100 flex">
              <p className="text-sm font-medium text-gray-800 leading-none">
                Status updates
              </p>
            </a>
            <a href="#" className="px-4 py-2 pb-4 hover:bg-gray-100 flex">
              <p className="text-sm font-medium text-gray-800 leading-none">
                Support FAQ
              </p>
            </a>
            <Link to={'/recruiters'}>
              <div href="#" className="px-4 py-2 pb-4 hover:bg-gray-100 flex">
                <p className="text-sm font-medium text-gray-800 leading-none">
                  Logout
                </p>
              </div>
            </Link>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Nav;
