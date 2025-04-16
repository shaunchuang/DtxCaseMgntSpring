import React, { useState, useRef, useEffect } from 'react';
import './TopBar.css';

const TopBar = () => {
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const dropdownRef = useRef(null);

  // Toggle dropdown menu visibility
  const toggleDropdown = () => {
    setDropdownOpen(!dropdownOpen);
  };

  // Close dropdown when clicking outside
  useEffect(() => {
    function handleClickOutside(event) {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setDropdownOpen(false);
      }
    }
    
    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, [dropdownRef]);

  const handleLogout = async () => {
    if (window.confirm('您確認要登出系統?')) {
      try {
        const response = await fetch('/security/api/logout', {
          method: 'POST',
          credentials: 'include',
          headers: {
            'Content-Type': 'application/json',
          },
        });
        if (response.ok) {
          window.location.href = '/login';
        } else {
          alert('登出失敗，請稍後再試');
        }
      } catch (error) {
        alert('登出時發生錯誤');
      }
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
        <div className="dropdown" ref={dropdownRef}>
          <button 
            className="btn btn-secondary dropdown-toggle" 
            type="button" 
            onClick={toggleDropdown}
          ></button>
          {dropdownOpen && (
            <div className="menu-item dropdown-menu show">
              <a className="dropdown-item" onClick={handleLogout}>登出</a>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default TopBar;