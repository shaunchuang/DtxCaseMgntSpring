import React from 'react';
import './TopBar.css';

const TopBar = () => {
  const handleLogout = () => {
    if (window.confirm('您確認要登出系統?')) {
      // In a real application, you would redirect to logout URL
      alert('Logging out...');
    }
  };

  return (
    <div className="top-bar">
      <div className="route pull-left">
        <ol id="breadcrumbs"></ol>
      </div>
      <div className="user-info pull-right">
        {/* Archive info would go here if needed */}
        <i className="fa fa-user"></i>
        工研院 系統管理員
        <div className="dropdown">
          <button className="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
          <div className="menu-item dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a className="dropdown-item" onClick={handleLogout}>登出</a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TopBar;