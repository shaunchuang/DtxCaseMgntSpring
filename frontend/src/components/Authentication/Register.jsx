import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Container, Row, Col, Form, Button, Card, Alert, InputGroup } from 'react-bootstrap';
import './Authentication.css';

const Register = () => {
  const [username, setUsername] = useState('');
  const [account, setAccount] = useState('');
  const [email, setEmail] = useState('');
  const [telCell, setTelCell] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [captcha, setCaptcha] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');
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
    
    // 前端基本驗證
    if (!username || !account || !email || !telCell || !password || !confirmPassword || !captcha) {
      setError('請填寫所有必填項目');
      return;
    }
    
    if (password !== confirmPassword) {
      setError('密碼與確認密碼不符');
      return;
    }
    
    // 電子郵件格式驗證
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      setError('請輸入有效的電子郵件地址');
      return;
    }
    
    // 手機號碼驗證 (台灣手機號碼格式)
    const phoneRegex = /^09\d{8}$/;
    if (!phoneRegex.test(telCell)) {
      setError('請輸入有效的手機號碼 (格式: 09xxxxxxxx)');
      return;
    }
    
    setLoading(true);
    setError('');
    setSuccess('');
    
    try {
      const response = await fetch('/security/api/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'X-XSRF-TOKEN': getCsrfToken()
        },
        body: JSON.stringify({
          username,
          account,
          email,
          telCell,
          password,
          captcha
        }),
        credentials: 'include'
      });
      
      const data = await response.json();
      
      if (data.success) {
        // 註冊成功
        setSuccess(data.message || '註冊成功，請等待管理員審核');
        // 清空表單
        setUsername('');
        setAccount('');
        setEmail('');
        setTelCell('');
        setPassword('');
        setConfirmPassword('');
        setCaptcha('');
        
        // 3秒後導向登入頁面
        setTimeout(() => {
          navigate('/login');
        }, 3000);
      } else {
        // 註冊失敗
        setError(data.message || '註冊失敗，請稍後再試');
        refreshCaptcha();
      }
    } catch (error) {
      console.error('註冊過程中發生錯誤:', error);
      setError('註冊過程中發生錯誤，請稍後再試');
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
      <Card className="register-card border-0 shadow">
        <Card.Body className="p-4">
          <div className="text-center mb-4">
            <h2 className="fw-bold mb-2">會員註冊</h2>
            <p className="text-muted">加入數位治療系統，建立您的個人帳號</p>
          </div>
          
          {error && <Alert variant="danger">{error}</Alert>}
          {success && <Alert variant="success">{success}</Alert>}
          
          <Form onSubmit={handleSubmit}>
            <Row>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>姓名</Form.Label>
                  <Form.Control 
                    type="text" 
                    value={username} 
                    onChange={(e) => setUsername(e.target.value)} 
                    placeholder="請輸入姓名"
                    required 
                  />
                </Form.Group>
              </Col>
              
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>帳號</Form.Label>
                  <Form.Control 
                    type="text" 
                    value={account} 
                    onChange={(e) => setAccount(e.target.value)} 
                    placeholder="請設定登入帳號"
                    required 
                  />
                </Form.Group>
              </Col>
            </Row>
            
            <Row>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>電子郵件</Form.Label>
                  <Form.Control 
                    type="email" 
                    value={email} 
                    onChange={(e) => setEmail(e.target.value)} 
                    placeholder="example@email.com"
                    required 
                  />
                </Form.Group>
              </Col>
              
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>手機號碼</Form.Label>
                  <Form.Control 
                    type="tel" 
                    value={telCell} 
                    onChange={(e) => setTelCell(e.target.value)} 
                    placeholder="09xxxxxxxx"
                    required 
                  />
                </Form.Group>
              </Col>
            </Row>
            
            <Row>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>密碼</Form.Label>
                  <Form.Control 
                    type="password" 
                    value={password} 
                    onChange={(e) => setPassword(e.target.value)} 
                    placeholder="請設定密碼"
                    required 
                  />
                </Form.Group>
              </Col>
              
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>確認密碼</Form.Label>
                  <Form.Control 
                    type="password" 
                    value={confirmPassword} 
                    onChange={(e) => setConfirmPassword(e.target.value)} 
                    placeholder="請再次輸入密碼"
                    required 
                  />
                </Form.Group>
              </Col>
            </Row>
            
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
            
            <div className="d-grid gap-2">
              <Button 
                variant="primary" 
                type="submit" 
                disabled={loading}
                className="btn-lg"
              >
                {loading ? '註冊中...' : '註冊'}
              </Button>
            </div>
          </Form>
          
          <div className="text-center mt-3">
            <p>
              已有帳號？ <Link to="/login" className="text-decoration-none">前往登入</Link>
            </p>
          </div>
        </Card.Body>
      </Card>
    </Container>
  );
};

export default Register;