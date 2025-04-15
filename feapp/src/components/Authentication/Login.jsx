import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Authentication.css';

const Login = () => {
  const [account, setAccount] = useState('');
  const [password, setPassword] = useState('');
  const [captcha, setCaptcha] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const reloadCaptcha = () => {
    document.getElementById("validateCodeImg").src = "/security/api/captcha?" + new Date().getTime();
  };

  const handleLogin = () => {
    setErrorMessage('');
    
    // Basic validation
    if (!account.trim() || !password.trim() || !captcha.trim()) {
      setErrorMessage('請填寫所有必填欄位');
      return;
    }

    // API call to the backend
    fetch('/security/api/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        account: account.trim(),
        password: password.trim(),
        captcha: captcha.trim()
      }),
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        // Check for daily login points
        if (data.dailyLoginPoints && data.dailyLoginPoints > 0) {
          const pointsMsg = data.dailyLoginMessage || '恭喜獲得每日登入獎勵！';
          const currentPointsVal = data.currentPoints || 0;
          
          // 使用 alert 顯示訊息，實際應用中可以使用更好的 UI 元件
          alert(`${pointsMsg}\n當前總積分: ${currentPointsVal}`);
          
          // 重定向到儀表板
          window.location.href = "/dashboard";
        } else {
          // 一般成功訊息
          alert(data.message);
          window.location.href = "/dashboard";
        }
      } else {
        setErrorMessage(data.message);
        setAccount('');
        setPassword('');
        setCaptcha('');
        reloadCaptcha();
      }
    })
    .catch(error => {
      console.error('Error:', error);
      setErrorMessage('登入失敗，請稍後再試');
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

      <div className="login-container">
        <h1>DTx 教案市集上架平台</h1>
        
        {/* Error message area */}
        {errorMessage && (
          <div className="alert alert-danger" role="alert">
            {errorMessage}
          </div>
        )}
        
        <div className="mb-3">
          <label htmlFor="account" className="form-label">帳號</label>
          <input 
            type="text" 
            id="account" 
            className="form-control" 
            placeholder="請輸入帳號" 
            value={account}
            onChange={(e) => setAccount(e.target.value)}
            required 
          />
        </div>
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
        <button 
          type="button" 
          className="btn btn-login w-100"
          onClick={handleLogin}
        >
          登入
        </button>
        
        <p className="text-center mt-3">
          還沒有帳號？<Link to="/register" className="text-primary">立即註冊</Link>
        </p>
      </div>
    </div>
  );
};

export default Login;