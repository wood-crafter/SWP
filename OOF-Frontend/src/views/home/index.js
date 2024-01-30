import './index.css'
import { Swiper, SwiperSlide } from 'swiper/react'
import 'swiper/css'
import { getRequest } from '../../providers/request'
import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router'
import { BASE_URL } from '../../constant'
import 'swiper/css';


export const Home = (props) => {
  const USDollar = new Intl.NumberFormat('vi-VI', {
    style: 'currency',
    currency: 'VND',
  })
  const [products, setProducts] = useState([])
  const navigate = useNavigate()
  const [categories, setCategories] = useState([])
  const [currentCategory, setCurrentCategory] = useState('')
  const [newProducts, setNewProducts] = useState([])
  const [hotProducts, setHotProducts] = useState([])
  const [categoriesImage, setCategoryImage] = useState([])
  const [banners, setBanners] = useState([])

  useEffect(() => {
    getRequest('banners').then(data => {
      const currentBanners = data.data.body
      setBanners(currentBanners)
    })
  }, [])
  useEffect(() => {
    getRequest('products').then(data => {
      const nextProducts = data.data.body
      if (!nextProducts.length) return
      const nextCategories = JSON.parse(JSON.stringify(categories))
      const nextCategoriesImage = JSON.parse(JSON.stringify(categoriesImage))
      nextProducts.forEach(item => {
        if (!nextCategories.includes(item.categoryName)) {
          nextCategories.push(item.categoryName)
          nextCategoriesImage.push(item)
        }
      })
      setProducts(nextProducts)
      const currentHotProducts = JSON.parse(JSON.stringify(nextProducts))
      currentHotProducts.sort((a, b) => b.price - a.price)
      if (currentHotProducts.length > 10) {
        currentHotProducts.length = 10
      }
      setHotProducts(currentHotProducts)
      setCategoryImage(nextCategoriesImage)
      setCategories(nextCategories)
      setCurrentCategory(nextCategories[0])
    })
  }, [])
  useEffect(() => {
    if (!currentCategory) return
    if (!products.length) return
    const productByCategory = []
    JSON.parse(JSON.stringify(products)).forEach(item => {
      if (item.categoryName === currentCategory) productByCategory.push(item)
    })
    productByCategory.sort((a, b) => b.id - a.id)
    if (productByCategory.length > 10) {
      productByCategory.length = 10
    }
    setNewProducts(productByCategory)
  }, [currentCategory])

  return (
    <div className='home'>
      <div className='news'>
        <Swiper
          spaceBetween={0}
          slidesPerView={1}
          loop={true}
          autoplay={{ delay: 200 }}
        >
          {banners.length && banners.map(item => {
            return <SwiperSlide><div className='swiper-slide-banner'><img style={{width: '100%'}} src={`${BASE_URL}${item.path}`}></img></div></SwiperSlide>
          })}
        </Swiper>
      </div>
      <div className='group-product-title'>Sản phẩm mới</div>
      <div className='product-container'>
        <Swiper
          spaceBetween={0}
          slidesPerView={3}
          loop={true}
        >
          {categories.length && categories.map(item => {
            return (<SwiperSlide><div className={`swiper-slide-tab ${item === currentCategory ? 'slide-tab-selected' : ''}`} onClick={() => { setCurrentCategory(item) }} >
              {item}
            </div></SwiperSlide>)
          })}
        </Swiper>
        <Swiper
          spaceBetween={0}
          slidesPerView={3}
          loop={true}
        >
          {newProducts.length && newProducts.map(item => {
            return (<SwiperSlide>
              <div className='swiper-slide-image' onClick={() => {navigate(`/productDetail/${item.id}`, {state: {id: item.id}})}} >
                <div className='home-product-image'><img  src={`${BASE_URL}${item.imagePath}`} /></div>
                <div className='home-product-name' style={{ display: 'flex', justifyContent: 'center' }}>{item.productName}</div>
                <div className='product-price' style={{ display: 'flex', justifyContent: 'center', color: 'rgb(214, 81, 123)' }}>{USDollar.format(item.price)}</div>
              </div>
            </SwiperSlide>)
          })}
        </Swiper>
      </div>
      <div className='group-product-title' style={{marginTop: '10rem'}}>Hot</div>
      <div className='product-container'>
        <Swiper
          spaceBetween={0}
          slidesPerView={3}
          loop={true}
        >
          {hotProducts.length && hotProducts.map(item => {
            return (<SwiperSlide><div className='swiper-slide-image' onClick={() => {navigate(`/productDetail/${item.id}`, {state: {id: item.id}})}} ><div className='swiper-slide-image' >
              <div className='home-product-image'><img  src={`${BASE_URL}${item.imagePath}`} width='auto' height='100%' /></div>
              <div className='home-product-name' style={{ display: 'flex', justifyContent: 'center' }}>{item.productName}</div>
              <div className='product-price' style={{ display: 'flex', justifyContent: 'center', color: 'rgb(214, 81, 123)' }}>{USDollar.format(item.price)}</div>
            </div></div></SwiperSlide>)
          })}
        </Swiper>
      </div>
      <div className='group-product-title' style={{marginTop: '10rem'}}>Danh sách sản phẩm</div>
      <div className='product-container'>
        <div className='categories'>
          {categories.length && categories.map((item, index) => {
            const max = categories.length / 2
            if (index < max) {
              return <div className='category' style={{fontSize: '2rem', backgroundPosition: 'center', backgroundImage: `url('http://localhost:8089${products.find(e => e.categoryName === item)?.imagePath}'`}} onClick={() => { navigate(`/product`, { state: { category: item } }) }}><div style={{backgroundColor: 'white', width: 'fit-content'}}>{item}</div></div>
            }
          })}
        </div>
        <div className='categories'>
          {categories.length && categories.map((item, index) => {
            const max = categories.length / 2
            if (index >= max) {
              return <div className='category' style={{fontSize: '2rem', backgroundPosition: 'center', backgroundImage: `url('http://localhost:8089${products.find(e => e.categoryName === item)?.imagePath}'`}} onClick={() => { navigate(`/product`, { state: { category: item } }) }} ><div style={{backgroundColor: 'white', width: 'fit-content'}}>{item}</div></div>
            }
          })}
        </div>
      </div>
    </div>
  )
}
