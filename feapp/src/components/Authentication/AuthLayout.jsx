import React from 'react';
import { Outlet, Link } from 'react-router-dom';
import './Authentication.css';

const AuthLayout = () => {
  return (
    <div className="auth-layout">
      {/* Header */}
      <header className="auth-header">
        <div className="container">
          <div className="logo">
            <Link to="/"><img src="/html/dtxstore/images/dtxstore/itri_EL_A.jpg" alt="ITRI Logo" /></Link>
          </div>
          <div className="header-nav-bar">
            <nav>
              <ul>
                <li><Link to="#"></Link></li>
              </ul>
            </nav>
          </div>
          <div className="auth-buttons">
            {window.location.pathname === '/register' ? (
              <Link to="/login"><button className="login">登入</button></Link>
            ) : (
              <Link to="/register"><button className="register">註冊</button></Link>
            )}
          </div>
        </div>
      </header>

      {/* Main content */}
      <main className="auth-main">
        <Outlet />
      </main>

      {/* Footer */}
      <footer className="auth-footer">
        <div className="container">
          <p className="mb-0">
            <b>版本 2.0</b>
          </p>
          <p className="mb-0">
            <a href="https://www.itri.org.tw/" target="_blank" rel="noopener noreferrer" className="text-muted">ITRI</a>. 版權所有 © 2024-2027
          </p>
        </div>
      </footer>
    </div>
  );
};

export default AuthLayout;