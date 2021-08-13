import React from 'react';
//import './style.css';
import logo from '../../../images/Logo.svg';

export const AppFooter = () => {
  return (
    <footer className="sticky bottom-0 left-0 footer items-center px-6 py-4 flex flex-wrap justify-between w-screen bg-gray-300">
      <div
        id="footer-promotional"
        className="flex flex-col flex-wrap content-start"
      >
        <img className="w-20 h-auto" src={logo} alt="Scouter Logo"></img>
        <div className="text-sm">Find your right fit with Scouter</div>
      </div>
      <div
        id="footer-contact"
        className="flex flex-col flex-wrap content-center"
      >
        <div id="footer-socials" className="flex flex-wrap content-between">
          <i className="fab fa-instagram-square" />
          <i className="fab fa-twitter-square" />
          <i className="fab fa-linkedin" />
          <i className="fab fa-tiktok" />
        </div>
        <div id="footer-copyright" className="flex flex-start content-around">
          <i className="far fa-copyright" />
          <span>2020 Scouter Ltd. All Rights Reserved</span>
        </div>
      </div>
    </footer>
  );
};
