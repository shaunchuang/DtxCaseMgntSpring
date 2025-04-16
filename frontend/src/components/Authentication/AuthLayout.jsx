import React from 'react';
import { Outlet, useLocation } from 'react-router-dom';
import { Container, Row, Col } from 'react-bootstrap';
import './Authentication.css';

const AuthLayout = () => {
  const location = useLocation();
  
  // 根據當前路徑判斷是登入還是註冊頁面
  const isLoginPage = location.pathname === '/login';
  
  return (
    <div className="auth-page">
      <Container fluid className="auth-container p-0">
        <Row className="g-0 h-100">
          <Col md={5} lg={6} className="auth-image-col d-none d-md-block">
            <div className="auth-image">
              <div className="auth-image-overlay">
                <div className="auth-image-content">
                  <div className="auth-logo mb-4">
                    <img src="/logo.png" alt="ITRI Logo" width="120" />
                    <h1 className="display-6 fw-bold text-white mt-3">數位治療系統</h1>
                  </div>
                  <h2 className="auth-title mb-4">
                    {isLoginPage ? '歡迎回來' : '加入我們'}
                  </h2>
                  <p className="auth-description">
                    {isLoginPage 
                      ? '數位治療管理系統提供您完整的治療方案管理與患者追蹤，讓您的醫療流程更加順暢。' 
                      : '註冊成為會員，開始使用數位治療管理系統，提升您的醫療服務品質與效率。'}
                  </p>
                </div>
              </div>
            </div>
          </Col>
          <Col md={7} lg={6} className="auth-form-col d-flex align-items-center justify-content-center">
            <Outlet />
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default AuthLayout;