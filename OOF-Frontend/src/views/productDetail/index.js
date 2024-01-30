import React, { useEffect, useState, useMemo, useContext } from 'react';
import { getRequest, postRequest } from '../../providers/request'
import './index.css'
import { useLocation } from "react-router-dom"
import { BASE_URL } from '../../constant'
import { InputNumber, notification } from 'antd'
import { useNavigate } from 'react-router'
import { AuthContext } from '../../providers/use-auth'
const Context = React.createContext({ name: 'Default' })

export const ProductDetail = (props) => {
  const USDollar = new Intl.NumberFormat('vi-VI', {
    style: 'currency',
    currency: 'VND',
  })
  const user = useContext(AuthContext).user
  const location = useLocation()
  const navigate = useNavigate()
  const id = location?.state?.id
  const [product, setProduct] = useState(null);
  const [productSizes, setProductSizes] = useState(null)
  const [currentSize, setCurrentSize] = useState(null)
  const [numOfProduct, setNumOfProduct] = useState(1)
  const [currentStockQuantity, setCurrentStockQuantity] = useState(0)
  const [productSize, setProductSize] = useState(null)
  const [api, contextHolder] = notification.useNotification()
  const [rate, setRate] = useState(-1)
  const [comment, setComment] = useState('')

  function onNumberChange (value) {
    setNumOfProduct(value)
  }

  const openNotification = (placement, message, description) => {
    api.info({
      message: message,
      description: description,
      placement,
    });
  };

  function hanldeRate(num) {
    setRate(num)
  }

  function handleMessageChange(e) {
    setComment(e.target.value)
  }

  function generateAsterisks(num) {
    if (typeof num !== 'number' || num <= 0) {
      return ''
    }
  
    return '⭐'.repeat(num);
  }

  function handleSizeClick (name, stockQuantity, id) {
    setCurrentSize(name)
    setProductSize(id)
    setCurrentStockQuantity(stockQuantity)
  }

  function handleAddToCard() {
    if (!currentSize && productSizes && productSizes[0].size != null ) {
      openNotification('topRight', 'Pick a size', `Please choose a size first`)
      return
    }
    if (numOfProduct > currentStockQuantity && productSizes && productSizes[0].size != null) {
      openNotification('topRight', 'Out of stock', `Size ${currentSize} only have ${currentStockQuantity} products left`)
      return
    }
    postRequest(`cart/add`, {productSize: {id: productSize}, quantity: numOfProduct}, user).then(data => {
      const code = data.status
      if (code == 200) {
        openNotification('topRight', 'Added to card', `Added to card ${numOfProduct} products`)
      } else {
        openNotification('topRight', 'Order failed', `Code ${code}`)
      }
    }).catch(e => {
      if (user) navigate(`/product`)
      else navigate(`/login`)
    })
  }

  function handleClickComment(id) {
    if (!comment) return
    if (rate < 0) {
      window.alert('Vui lòng đánh giá sản phẩm')
      return
    }
    postRequest(`products/comment`, {product: {id}, comment: comment, star: rate}, user).then(data => {
      const code = data.status
      if (code == 200) loadProductDetai()
    }).catch(e => {
      if (e.response.status == 401) {
        window.alert('Vui lòng đăng nhập')
        navigate('/login')
        return;
      }
      window.alert('Bình luận lỗi')
    })
  }

  function loadProductDetai() {
    if (!id) navigate(`/products`)
    getRequest(`products/${id}`).then(data => {
      const currentProduct = data.data.body
      setProductSizes(currentProduct.productSizes)
      if (currentProduct.productSizes[0].size) {
        setCurrentSize(currentProduct.productSizes[0].size.name)
      }
      setProductSize(currentProduct.productSizes[0].id)
      setCurrentStockQuantity(currentProduct.productSizes[0].stockQuantity)
      setProduct(currentProduct)
    }).catch(e => {
      navigate(`/products`)
    })
  }

  useEffect(() => {
    loadProductDetai()
  }, [])
  const contextValue = useMemo(() => ({ name: 'Ant Design' }), [])
  return (
    <Context.Provider value={contextValue}>
      {contextHolder}
      <div className='product-detail-container'>
        {product && (
          <div>
            <div className='product-detail-info'>
              <div style={{marginLeft: '35rem'}}>
                <div className='product-name-detail'>{product.name}</div>
                <div>
                  <div style={{display: 'flex', marginTop: '2rem', marginBottom: '1rem'}}>
                    <div>Mặt hàng:</div>
                    <div style={{color: 'coral', marginLeft: '2px'}}>{product.category.name}</div>
                  </div>
                  <div style={{display: 'flex', marginBottom: '1rem'}}>
                    <div>Nhà cung cấp: </div>
                    <div style={{color: 'coral', marginLeft: '2px'}}>{product.supplier.name}</div>
                  </div>
                  <div style={{color: '#ee3d51'}}>{USDollar.format(product.price)}</div>
                </div>
              </div>
            </div>
            <div className='product-detail'>
              <div className='product-image'>
                <img src={`${BASE_URL}${product.path}`} width='auto' height='100%' />
              </div>
              <div className='discount' style={{padding: '1rem'}}>
              <div class="product-promotions-list-content">
									<p>✔ Thanh toán sau khi kiểm tra và nhận hàng<br/>
✔ Hỗ trợ đổi size</p>

<p><strong>🎁Ưu đãi thêm khi mua sản phẩm tại <a href="/">OOF Badminton</a></strong></p>

<p>✅ <a href="/">Sơn logo mặt vợt</a> miễn phí</p>

<p>✅ <a href="/">Bảo hành lưới đan</a> trong 72 giờ</p>

<p>✅&nbsp;<a href="/">Thay gen vợt</a> miễn phí trọn đời</p>

<p>✅ <a href="/">Tích luỹ điểm thành viên</a> Premium</p>

<p>✅ <a href="/">Voucher giảm giá</a> cho lần mua hàng tiếp theo</p>										</div>
              </div>
            </div>
            <div className='cart-info'>
              <div className='size-info'>
                {productSizes && productSizes.map(item => {
                  if (!item.size) return
                  return <button value={item.size.name} className={`${currentSize == item.size.name ? 'size selected-size ' : 'size '}${item.stockQuantity == 0 ? 'out-of-stock' : ''}`} onClick={() => {if (item.stockQuantity) handleSizeClick(item.size.name, item.stockQuantity, item.id)}}>{item.size.name}</button>
                })}
              </div>
              <div className='order-info'>
                <InputNumber min={1} max={9999} defaultValue={1} onChange={onNumberChange} />
                <button className='add-to-cart' onClick={handleAddToCard} >Add to card</button>
              </div>
            </div>
            <div className='detail'>
              <div style={{fontSize: '2rem'}}>Thông số kỹ thuật</div>
              {product.description.split("##").map(e => {
                return <div style={{marginBottom: '0.5rem'}}>{e}</div>
              })}
            </div>
            <div className='comment'>
              <div style={{fontSize: '2rem'}}>Bình luận</div>
              {product.comments.map(e => {
                return <div>
                  <div style={{marginLeft: '7rem'}}>
                    <div style={{display: 'flex', alignItems: 'center', width: 'fit-content'}}>
                      <div style={{height: '3rem', width: '3rem'}}><img style={{width: 'auto', height: '100%'}} src="https://static.vecteezy.com/system/resources/thumbnails/020/765/399/small/default-profile-account-unknown-icon-black-silhouette-free-vector.jpg"/></div>
                      <div>{e.commentator}</div>
                    <div style={{marginLeft: '0.5rem'}}>{generateAsterisks(e.star)}</div>
                    </div>
                    <div style={{marginLeft: '3rem', marginBottom: '1rem', marginTop: '0.5rem'}}>{e.comment}</div>
                  </div>
                </div>
              })}
              <textarea onChange={handleMessageChange} placeholder='Để lại bình luận' style={{marginLeft: '7rem', width: 'calc(100% - 7rem)', marginTop: '1rem', minHeight: '7rem'}}></textarea>
              <div style={{width: '100%', display: 'flex', justifyContent: 'end', marginBottom: '1rem'}}>
                <button className='star' style={{backgroundColor: 'white', border: '0', fontSize: '1.3rem'}} onClick={() => {hanldeRate(1)}}>{rate < 1 ? '☆' : '⭐'}</button>
                <button className='star' style={{backgroundColor: 'white', border: '0', fontSize: '1.3rem'}} onClick={() => {hanldeRate(2)}}>{rate < 2 ? '☆' : '⭐'}</button>
                <button className='star' style={{backgroundColor: 'white', border: '0', fontSize: '1.3rem'}} onClick={() => {hanldeRate(3)}}>{rate < 3 ? '☆' : '⭐'}</button>
                <button className='star' style={{backgroundColor: 'white', border: '0', fontSize: '1.3rem'}} onClick={() => {hanldeRate(4)}}>{rate < 4 ? '☆' : '⭐'}</button>
                <button className='star' style={{backgroundColor: 'white', border: '0', fontSize: '1.3rem'}} onClick={() => {hanldeRate(5)}}>{rate < 5 ? '☆' : '⭐'}</button>
              </div>
              <div style={{width: '100%', display: 'flex', justifyContent: 'end'}}><button onClick={() => {handleClickComment(product.id)}} className='btn-commnet' style={{background: 'coral', border: '0', width: '6rem', height: '2rem'}}>Bình luận</button></div>
            </div>
          </div>)
        }
      </div>
    </Context.Provider>
  )
}
