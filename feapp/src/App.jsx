import { useState } from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import './App.css'
import AuthLayout from './components/Authentication/AuthLayout'
import Login from './components/Authentication/Login'
import Register from './components/Authentication/Register'
import DTxDashboard from './components/Dashboard/DTxDashboard'

function App() {
  return (
    <Router>
      <Routes>
        {/* Authentication Routes */}
        <Route path="/" element={<AuthLayout />}>
          <Route index element={<Navigate to="/login" replace />} />
          <Route path="login" element={<Login />} />
          <Route path="register" element={<Register />} />
        </Route>
        
        {/* Dashboard Route - protected route in a real app */}
        <Route path="/dashboard" element={<DTxDashboard />} />
        
        {/* Fallback route - redirect to login */}
        <Route path="*" element={<Navigate to="/login" replace />} />
      </Routes>
    </Router>
  )
}

export default App
