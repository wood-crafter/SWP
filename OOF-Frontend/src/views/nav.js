import React, { useState, useContext } from 'react'
import { Menu } from 'antd'
import { ShoppingOutlined, ShoppingCartOutlined, LoginOutlined,LogoutOutlined, DollarOutlined, FormOutlined, ExceptionOutlined, QuestionCircleOutlined, InfoCircleOutlined, ContactsOutlined } from '@ant-design/icons';
import { useNavigate } from 'react-router'
import { AuthContext } from '../providers/use-auth'
import { useAuth } from '../providers/use-auth'

const items = [
  {
    label: 'Trang chủ',
    key: 'home',
    redirectTo: '/home',
  },
  {
    label: 'Sản phẩm',
    key: 'product',
    redirectTo: '/product',
    icon: <ShoppingOutlined style={{fontSize: '20px'}} />,
  },
  {
    label: 'Khuyến mãi',
    key: 'sale',
    redirectTo: '/sale',
    icon: <DollarOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Sản phẩm mới',
    key: 'news',
    redirectTo: '/news',
    icon: <FormOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Chính sách',
    key: 'policy',
    redirectTo: '/policy',
    icon: <ExceptionOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Hướng dẫn',
    key: 'guide',
    redirectTo: '/guide',
    icon: <QuestionCircleOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Về chúng tôi',
    key: 'about',
    redirectTo: '/about',
    icon: <InfoCircleOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Liên hệ',
    key: 'contact',
    redirectTo: '/contact',
    icon: <ContactsOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Đăng nhập',
    key: '/login',
    redirectTo: '/login',
    icon: <LoginOutlined style={{fontSize: '20px'}} />
  }
]

const itemsLogged = [
  {
    label: 'Trang chủ',
    key: 'home',
    redirectTo: '/home',
  },
  {
    label: 'Sản phẩm',
    key: 'product',
    redirectTo: '/product',
    icon: <ShoppingOutlined style={{fontSize: '20px'}} />,
  },
  {
    label: 'Khuyến mãi',
    key: 'sale',
    redirectTo: '/sale',
    icon: <DollarOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Sản phẩm mới',
    key: 'news',
    redirectTo: '/news',
    icon: <FormOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Chính sách',
    key: 'policy',
    redirectTo: '/policy',
    icon: <ExceptionOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Hướng dẫn',
    key: 'guide',
    redirectTo: '/guide',
    icon: <QuestionCircleOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Về chúng tôi',
    key: 'about',
    redirectTo: '/about',
    icon: <InfoCircleOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Liên hệ',
    key: 'contact',
    redirectTo: '/contact',
    icon: <ContactsOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Đơn hàng',
    key: 'order',
    redirectTo: '/order',
    icon: <ShoppingCartOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Giỏ hàng',
    key: 'cart',
    redirectTo: '/cart',
    icon: <ShoppingCartOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Đăng xuất',
    key: '/logout',
    redirectTo: '/logout',
    icon: <LogoutOutlined style={{fontSize: '20px'}} />
  }
]

const totalItem = [
  {
    label: 'Trang chủ',
    key: 'home',
    redirectTo: '/home',
  },
  {
    label: 'Sản phẩm',
    key: 'product',
    redirectTo: '/product',
    icon: <ShoppingOutlined style={{fontSize: '20px'}} />,
  },
  {
    label: 'Khuyến mãi',
    key: 'sale',
    redirectTo: '/sale',
    icon: <DollarOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Sản phẩm mới',
    key: 'news',
    redirectTo: '/news',
    icon: <FormOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Chính sách',
    key: 'policy',
    redirectTo: '/policy',
    icon: <ExceptionOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Hướng dẫn',
    key: 'guide',
    redirectTo: '/guide',
    icon: <QuestionCircleOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Về chúng tôi',
    key: 'about',
    redirectTo: '/about',
    icon: <InfoCircleOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Liên hệ',
    key: 'contact',
    redirectTo: '/contact',
    icon: <ContactsOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Đơn hàng',
    key: 'order',
    redirectTo: '/order',
    icon: <ShoppingCartOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Giỏ hàng',
    key: 'cart',
    redirectTo: '/cart',
    icon: <ShoppingCartOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Đăng xuất',
    key: '/logout',
    redirectTo: '/logout',
    icon: <LogoutOutlined style={{fontSize: '20px'}} />
  },
  {
    label: 'Đăng nhập',
    key: '/login',
    redirectTo: '/login',
    icon: <LoginOutlined style={{fontSize: '20px'}} />
  }
]

export const Nav = () => {
  const { logout } = useAuth()
  const auth = useContext(AuthContext)
  const [current, setCurrent] = useState(window.location.pathname.substring(1))
  const navigate = useNavigate()
  const onClick = (e) => {
    const redirectTo = totalItem.find(item => {
      return item.key == e.key
    }).redirectTo
    if (redirectTo == '/logout') {
      logout()
      return
    }
    setCurrent(e.key)
    navigate(redirectTo, { replace: true })
  };

  return (
    <Menu style={{height: '7vh', display: 'flex', justifyContent: 'center'}} onClick={onClick} mode="horizontal" selectedKeys={[current]} items={auth.user ? itemsLogged : items} />
  )
}
