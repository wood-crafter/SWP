import { useEffect, useState, useContext } from 'react';
import { getRequest, postRequest } from '../../providers/request'
import './index.css'
import { useLocation } from "react-router-dom"
import { BASE_URL } from '../../constant'
import { Checkbox } from 'antd'
import { useNavigate } from 'react-router'
import { AuthContext } from '../../providers/use-auth'

export const Cart = (props) => {
  const USDollar = new Intl.NumberFormat('vi-VI', {
    style: 'currency',
    currency: 'VND',
  })
  const user = useContext(AuthContext).user
  const [cart, setCart] = useState(null)
  const [selectedCards, setSelectedCards] = useState([])
  const navigate = useNavigate()

  function onCheckboxChange(e, id) {
    const nextSeletedCart = JSON.parse(JSON.stringify(selectedCards))
    if (e.target.checked) {
      nextSeletedCart.push(id)
      setSelectedCards(nextSeletedCart)
    } else {
      removeElement(nextSeletedCart, id)
      setSelectedCards(nextSeletedCart)
    }
  }

  function removeElement(array, elem) {
    var index = array.indexOf(elem);
    if (index > -1) {
        array.splice(index, 1);
    }
}

  function handleOrderAll() {
    if (!selectedCards.length) return
    const url = '/orders/create'
    postRequest(url, selectedCards, user).then(data => {
      if(data.status === 200) {
        setSelectedCards([])
        handleLoadCart()
      }
      else {
        window.alert('Order fail with code:' + data.status)
      }
    }).catch(e => {
      window.alert(e)
    })
  }

  function handleRemoveAll() {
    if (!selectedCards.length) return
    const url = '/cart/delete'
    postRequest(url, selectedCards, user).then(data => {
      if(data.status === 200) {
      selectedCards([])
      handleLoadCart()
      }
    }).catch(e => {
      window.alert(e)
    })
  }

  function handleLoadCart() {
    getRequest('/cart', null, user).then(data => {
      const carts = data.data.body
      setCart(carts)
    }).catch(e => {
      navigate(`/product`)
    })
  }

  useEffect(() => {
    handleLoadCart()
  }, [])

  return (
    <div className='cart-container'>
      {cart && 
      <div className='cart-body'>
        <table>
          <tr>
            <th></th>
            <th>Tên sản phẩm</th>
            <th>Giá sản phẩm</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
            <th></th>
          </tr>
          {cart.map(item => {
            return (
              <tr key={item.id}>
                <td><img style={{width: 'auto', height: '15rem'}} src={`${BASE_URL}${item.productSize.product.path}`}/></td>
                <td>{item.productSize.product.name}</td>
                <td>{USDollar.format(item.productSize.product.price)}</td>
                <td>{item.quantity}</td>
                <td>{USDollar.format(item.quantity * item.productSize.product.price)}</td>
                <td>
                  <Checkbox onChange={(e) => {onCheckboxChange(e, item.id)}} />
                </td>
              </tr>
            )
          })}
        </table>
        <div className='action-all'>
          <div className='order-all button' onClick={handleOrderAll}>Đặt mua</div>
          <div className='remove-all button' onClick={handleRemoveAll}>Xóa đơn</div>
        </div>
      </div>
      }
    </div>
  )
}
