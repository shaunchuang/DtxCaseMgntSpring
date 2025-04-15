import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Authentication.css';

const Register = () => {
  const [username, setUsername] = useState('');
  const [account, setAccount] = useState('');
  const [email, setEmail] = useState('');
  const [telCell, setTelCell] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [captcha, setCaptcha] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const reloadCaptcha = () => {
    document.getElementById("validateCodeImg").src = "/security/api/captcha?" + new Date().getTime();
  };

  const handleRegister = () => {
    setErrorMessage('');
    
    // Basic validation
    if (!username.trim()) {
      setErrorMessage('姓名未填寫，請輸入您的姓名');
      return;
    }
    if (!account.trim()) {
      setErrorMessage('帳號未填寫，請輸入帳號名稱');
      return;
    }
    if (!email.trim()) {
      setErrorMessage('電子郵件未填寫，請輸入電子郵件');
      return;
    }
    if (!telCell.trim()) {
      setErrorMessage('手機號碼未填寫，請輸入您的手機號碼');
      return;
    }
    if (!password) {
      setErrorMessage('密碼未填寫，請輸入密碼');
      return;
    }
    if (!confirmPassword) {
      setErrorMessage('確認密碼未填寫，請再次輸入密碼');
      return;
    }
    if (password !== confirmPassword) {
      setErrorMessage('密碼不一致，兩次輸入的密碼不一致！');
      return;
    }

    // API call to the backend
    fetch('/security/api/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        username,
        account,
        email,
        telCell,
        password,
        captcha
      }),
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        // Success message
        alert('註冊成功，正在跳轉至登入頁面...');
        window.location.href = "/login"; // Redirect to login page
      } else {
        setErrorMessage(data.message);
        setCaptcha('');
        reloadCaptcha();
      }
    })
    .catch(error => {
      console.error('Error:', error);
      setErrorMessage('註冊失敗，請檢查輸入資訊或稍後再試');
      reloadCaptcha();
    });
  };

  return (
    <div className="auth-container">
      {/* Background bubbles */}
      <ul className="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
      </ul>

      <div className="register-container">
        <h1>DTx 教案市集上架平台 - 註冊</h1>
        
        {/* Error message area */}
        {errorMessage && (
          <div className="alert alert-danger" role="alert">
            {errorMessage}
          </div>
        )}
        
        <div className="row">
          <div className="col-md-6">
            <div className="mb-3">
              <label htmlFor="username" className="form-label">姓名</label>
              <input 
                type="text" 
                id="username" 
                className="form-control" 
                placeholder="請輸入姓名" 
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required 
              />
            </div>
            <div className="mb-3">
              <label htmlFor="account" className="form-label">帳號名稱</label>
              <input 
                type="text" 
                id="account" 
                className="form-control" 
                placeholder="請輸入帳號名稱" 
                value={account}
                onChange={(e) => setAccount(e.target.value)}
                required 
              />
            </div>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">電子郵件</label>
              <input 
                type="email" 
                id="email" 
                className="form-control" 
                placeholder="請輸入電子郵件" 
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required 
              />
            </div>
            <div className="mb-3">
              <label htmlFor="telCell" className="form-label">手機號碼</label>
              <input 
                type="tel" 
                id="telCell" 
                className="form-control" 
                placeholder="請輸入10位手機號碼" 
                pattern="[0-9]{10}" 
                value={telCell}
                onChange={(e) => setTelCell(e.target.value)}
                required 
              />
            </div>
          </div>
          <div className="col-md-6">
            <div className="mb-3">
              <label htmlFor="password" className="form-label">密碼</label>
              <input 
                type="password" 
                id="password" 
                className="form-control" 
                placeholder="請輸入密碼" 
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required 
              />
            </div>
            <div className="mb-3">
              <label htmlFor="confirmPassword" className="form-label">確認密碼</label>
              <input 
                type="password" 
                id="confirmPassword" 
                className="form-control" 
                placeholder="請再次輸入密碼" 
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
                required 
              />
            </div>
            <div className="mb-3">
              <label htmlFor="captcha" className="form-label">驗證碼</label>
              <div className="d-flex align-items-center">
                <img 
                  id="validateCodeImg" 
                  src="/security/api/captcha" 
                  alt="captcha" 
                  className="me-2" 
                  style={{ cursor: 'pointer' }} 
                  onClick={reloadCaptcha} 
                />
                <i 
                  className="fa-solid fa-arrows-rotate text-primary" 
                  style={{ cursor: 'pointer' }} 
                  onClick={reloadCaptcha}
                ></i>
                <input 
                  type="text" 
                  id="captcha" 
                  className="form-control ms-2" 
                  placeholder="請輸入驗證碼" 
                  value={captcha}
                  onChange={(e) => setCaptcha(e.target.value)}
                  required 
                />
              </div>
            </div>
          </div>
        </div>
        <div className="btn-bl">
          <button 
            type="button" 
            className="btn btn-register w-25"
            onClick={handleRegister}
          >
            註冊
          </button>
        </div>
        
        <p className="text-center mt-3">
          已有帳號？<Link to="/login" className="text-primary">立即登入</Link>
        </p>
      </div>
    </div>
  );
};

export default Register;