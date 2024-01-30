import { useEffect, useState, useContext } from 'react'
import { getRequest, postRequest } from '../../providers/request'
import { AuthContext } from '../../providers/use-auth'
import { useNavigate } from 'react-router'
import { BASE_URL } from '../../constant'
import './index.css'

export const Order = (props) => {
  const USDollar = new Intl.NumberFormat('vi-VI', {
    style: 'currency',
    currency: 'VND',
  })
  const user = useContext(AuthContext).user
  const [orders, setOrders] = useState([])
  const navigate = useNavigate()

  function handleLoadOrder() {
    getRequest('/orders', null, user).then(data => {
      const currentUrders = data.data.body
      setOrders(currentUrders)
    }).catch(e => {
      navigate(`/product`)
    })
  }
  
  useEffect(() => {
    handleLoadOrder()
  }, [])

  return (
    <div className='order-container'>
      {orders.length ? (
        <div className='order-body'>
          {orders.map(item => {
          return (
            <div className='order-card'>
              <div className='order-status' style={{color: `${item.order.status ? 'green' : 'rgb(181, 215, 14)'}`}}><div style={{marginRight: '0.5rem'}}>{item.order.status ? 'Đơn hàng thành công' : 'Đơn hàng đang giao'}</div></div>
              {item.orderProducts.map(product => {
                return (
                  <div className='order-card-body'> 
                    <img className='order-image' src={`${BASE_URL}${product.path}`} width='100%' height='80%' />
                    <div className='order-detail'>
                      <div className='order-product-name'>{product.productName}</div>
                      <div className='order-category-name'>{product.categoryName}</div>
                      <div className='order-supplier-name'>{product.supplierName}</div>
                      <div className='order-quantity'>x{product.quantity}</div>
                    </div>
                    <div className='unit-price'>{USDollar.format(product.unitPrice)}</div>
                  </div>
                )
              })}
              <div className='total-price'>Thành tiền: {USDollar.format(item.orderProducts.reduce((accumulator, object) => {
                return accumulator + object.quantity * object.unitPrice;
                }, 0))}
              </div>
            </div>
          )
        })}
        </div>
      ) : <div>Order empty</div>
      }
    </div>
  )
}
