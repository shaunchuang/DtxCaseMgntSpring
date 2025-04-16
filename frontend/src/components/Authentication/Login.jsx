import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Container, Row, Col, Form, Button, Card, Alert, InputGroup } from 'react-bootstrap';
import './Authentication.css';

const Login = () => {
  const [account, setAccount] = useState('');
  const [password, setPassword] = useState('');
  const [captcha, setCaptcha] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const [captchaUrl, setCaptchaUrl] = useState('');
  
  const navigate = useNavigate();

  // 刷新驗證碼
  const refreshCaptcha = () => {
    // 使用相對路徑，會通過 Vite 的代理轉發到後端
    const timestamp = new Date().getTime();
    setCaptchaUrl(`/security/api/captcha?t=${timestamp}`);
  };

  // CSRF 令牌處理
  const getCsrfToken = () => {
    const cookieValue = document.cookie
      .split('; ')
      .find(row => row.startsWith('XSRF-TOKEN='))
      ?.split('=')[1];
    return cookieValue || '';
  };

  // 表單提交處理
  const handleSubmit = async (e) => {
    e.preventDefault();
    
    if (!account || !password || !captcha) {
      setError('請填寫所有必填項目');
      return;
    }
    
    setLoading(true);
    setError('');
    
    try {
      const response = await fetch('/security/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'X-XSRF-TOKEN': getCsrfToken()
        },
        body: JSON.stringify({
          account,
          password,
          captcha
        }),
        credentials: 'include'
      });
      
      const data = await response.json();
      
      if (data.success) {
        // 登入成功
        localStorage.setItem('user', JSON.stringify(data.user));
        navigate('/dashboard');
      } else {
        // 登入失敗
        setError(data.message || '登入失敗，請檢查帳號和密碼');
        refreshCaptcha();
      }
    } catch (error) {
      console.error('登入過程中發生錯誤:', error);
      setError('登入過程中發生錯誤，請稍後再試');
      refreshCaptcha();
    } finally {
      setLoading(false);
    }
  };

  // 頁面加載時刷新驗證碼
  useEffect(() => {
    refreshCaptcha();
  }, []);

  return (
    <Container className="py-4">
      <Card className="login-card border-0 shadow">
        <Card.Body className="p-4">
          <div className="text-center mb-4">
            <h2 className="fw-bold mb-2">登入系統</h2>
            <p className="text-muted">請輸入您的帳號密碼</p>
          </div>
          
          {error && <Alert variant="danger">{error}</Alert>}
          
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3">
              <Form.Label>帳號</Form.Label>
              <Form.Control 
                type="text" 
                value={account} 
                onChange={(e) => setAccount(e.target.value)} 
                placeholder="請輸入帳號"
                required 
              />
            </Form.Group>
            
            <Form.Group className="mb-3">
              <Form.Label>密碼</Form.Label>
              <Form.Control 
                type="password" 
                value={password} 
                onChange={(e) => setPassword(e.target.value)} 
                placeholder="請輸入密碼"
                required 
              />
            </Form.Group>
            
            <Form.Group className="mb-4">
              <Form.Label>驗證碼</Form.Label>
              <InputGroup>
                <Form.Control 
                  type="text" 
                  value={captcha} 
                  onChange={(e) => setCaptcha(e.target.value)} 
                  placeholder="請輸入驗證碼"
                  required 
                />
                {captchaUrl ? (
                  <img 
                    src={captchaUrl} 
                    alt="驗證碼" 
                    onClick={refreshCaptcha} 
                    className="captcha-image border" 
                    style={{ cursor: 'pointer', height: '38px' }}
                  />
                ) : (
                  <Button 
                    variant="outline-secondary" 
                    onClick={refreshCaptcha}
                  >
                    載入驗證碼
                  </Button>
                )}
              </InputGroup>
              <Form.Text className="text-muted">
                點擊圖片重新整理驗證碼
              </Form.Text>
            </Form.Group>
            
            <div className="d-grid gap-2 mt-4">
              <Button 
                variant="primary" 
                type="submit" 
                disabled={loading}
                className="btn-lg"
              >
                {loading ? '登入中...' : '登入'}
              </Button>
            </div>
          </Form>
          
          <div className="text-center mt-3">
            <p>
              還沒有帳號？ <Link to="/register" className="text-decoration-none">前往註冊</Link>
            </p>
          </div>
        </Card.Body>
      </Card>
    </Container>
  );
};

export default Login;