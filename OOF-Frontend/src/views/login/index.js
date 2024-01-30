import './index.css'
import React, { useState } from 'react'
import { useNavigate } from 'react-router'
import { useAuth } from '../../providers/use-auth'

export const Login = (props) => {
  const { redirectTo = '/home' } = props
  const { attemptLogin } = useAuth()
  const navigate = useNavigate()
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')

  const signinHandler = async e => {
    e.preventDefault()
    setError('')
    try {
      await attemptLogin(username, password)
      navigate(redirectTo, { replace: true })
    } catch (error) {
      setError(error.message)
    }
  }

  return (
    <div className='login-container'>
      <div className='app-name'>OOF BADMINTON</div>
      <div className='login-form' >
        <div className='form-head'>Đăng nhập</div>
        <div className='form-content'>
          <div className='input-container'>
            <input className='username input' placeholder='Username' onChange={e => setUsername(e.target.value)} value={username} type="text" ></input>
            <input className='password input' placeholder='Password' onChange={e => setPassword(e.target.value)} value={password} type="password" ></input>
            <div className='forgot-account-container'>
              <a className='forgot-account'>Quên mật khẩu?</a>
            </div>
          </div>

          <div className='signin-container'>
            <div style={{ display: error ? 'block' : 'hidden' }} className='error'>{error ? 'Oops, account not match!' : ''}</div>
            <button className='signin' onClick={signinHandler} >Đăng nhập</button>
          </div>

          <div className='signup-container'>
            <div className='signup-title'>Chưa có tài khoản?</div>
            <a className='signup'>Đăng ký ngay</a>
          </div>
        </div>
      </div>
    </div>
  )
}
