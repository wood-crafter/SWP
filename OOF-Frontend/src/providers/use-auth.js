import { createContext, useCallback, useContext, useState } from 'react'
import { getRequest, postRequest } from './request'

const USER_SS_KEY = '#_user_#'

export const AuthContext = createContext(null)
export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(JSON.parse(sessionStorage.getItem(USER_SS_KEY)))

  const proxiedSetUser = useCallback((user) => {
    if (user) {
      sessionStorage.setItem(USER_SS_KEY, JSON.stringify(user))
    } else {
      sessionStorage.getItem(USER_SS_KEY)
    }
    setUser(user)
  }, [])

  return (
    <AuthContext.Provider value={{ user, setUser: proxiedSetUser }}>
      {children}
    </AuthContext.Provider>
  )
}

export const useAuth = () => {
  const { user, setUser } = useContext(AuthContext)
  return {
    user,
    async attemptLogin (username, password) {
      await postRequest('auth/sign-in', {username, password}).then(res => {
        if (res.data.code == 200) {
          setUser(res.data.body)
        } else {
          throw new Error('Thông tin đăng nhập sai...!')
        }
      }).catch(e => {
          throw new Error('Thông tin đăng nhập sai...!')
      })
    },
    async logout () {
      setUser(null)
    }
  }
}
