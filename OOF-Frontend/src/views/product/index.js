import { useEffect, useState } from 'react';
import { getRequest } from '../../providers/request'
import './index.css'
import { useLocation } from "react-router-dom"
import { BASE_URL } from '../../constant'
import { Radio, Space } from 'antd'
import { useNavigate } from 'react-router'

const orderOptions = [
  { label: 'Giá tăng dần', value: 'increase' },
  { label: 'Giá giảm dần', value: 'degrease' },
]

export const Product = (props) => {
  const USDollar = new Intl.NumberFormat('vi-VI', {
    style: 'currency',
    currency: 'VND',
  })
  const [products, setProducts] = useState([])
  const [categories, setCategories] = useState([])
  const [groupOfFour, setGroupOfFour] = useState([])
  const navigate = useNavigate()
  const location = useLocation()
  const [originalProducts, setOriginalProducts] = useState([])
  const [selectedCategory, setSelectedCategory] = useState('')
  const [selectedSupplier, setSelectedSupplier] = useState('')
  const [suppliers, setSuppliers] = useState([])

  function chunkArray(arr, chunkSize) {
    const chunkedArray = [];
    for (let i = 0; i < arr.length; i += chunkSize) {
      chunkedArray.push(arr.slice(i, i + chunkSize));
    }
    return chunkedArray;
  }

  function onFilterChange(e) {
    const nextProducts = JSON.parse(JSON.stringify(products))
    nextProducts.sort((current, next) => {
      if (e.target.value === 'increase') {
        return current.price - next.price
      }
      return next.price - current.price
    })
    setProducts(nextProducts)
  }

  function handleProductClick(id) {
    navigate(`/productDetail/${id}`, {state: {id}})
  }

  function handleCategory(name) {
    if (name == selectedCategory) {
      setSelectedCategory('')
      return
    }
    setSelectedCategory(name)
    if (originalProducts.length == 0) setOriginalProducts(products)
  }

  function handleSupplier(name) {
    if (name == selectedSupplier) {
      setSelectedSupplier('')
      return
    }
    setSelectedSupplier(name)
    if (originalProducts.length == 0) setOriginalProducts(products)
  }

  useEffect(() => {
    let nextProducts = JSON.parse(JSON.stringify(originalProducts))
    nextProducts = nextProducts.filter(item => {
      let supplierCondition = true
      let categoryCondition = true
      if (selectedSupplier != '') supplierCondition = item.supplierName == selectedSupplier
      if (selectedCategory != '') categoryCondition = item.categoryName == selectedCategory
      return categoryCondition && supplierCondition
    })
    setProducts(nextProducts)
  }, [selectedSupplier, selectedCategory])

  useEffect(() => {
    const currentCategoryName = location?.state?.category
    getRequest('categories').then(data => {
      const resCategories = data.data.body
      setCategories(resCategories)
      const currentCategory = resCategories.find(item => item?.name == currentCategoryName)
      if (currentCategory) {
        getRequest('products', { categoryId: currentCategory.id }).then(res => {
          const nextProducts = res.data.body
          setProducts(nextProducts)
        })
      } else {
        getRequest('products').then(res => {
          const nextProducts = res.data.body
          setProducts(nextProducts)
        })
      }
    })

    getRequest('suppliers').then(data => {
      const resSuppliers = data.data.body
      setSuppliers(resSuppliers)
    })
  }, [])

  useEffect(() => {
    const chunkSize = 4
    const result = chunkArray(JSON.parse(JSON.stringify(products)), chunkSize)
    setGroupOfFour(result)
  }, [products])

  return (
    <div className='products'>
      <div className="filter">
        <Radio.Group onChange={onFilterChange}>
          <Space direction="vertical">
            {orderOptions.map((item) => {
              return <Radio value={item.value}>{item.label}</Radio>
            })}
          </Space>
        </Radio.Group>
        <Space direction="vertical">
            <div style={{marginTop: '0.3rem', fontSize: '1.3rem'}}>Chủng loại</div>
            {categories.map((item) => {
              return <div style={{display: 'flex', alignItems: 'center', color: `${selectedCategory == item.name ? 'coral' : 'black'}`}} className='filter-category' onClick={() => {handleCategory(item.name)}}><div style={{fontSize: '2rem', display: 'flex', alignItems: 'center', height: '100%'}}>&#x2022;</div>{item.name}</div>
            })}
        </Space>
        <Space direction="vertical">
            <div style={{marginTop: '0.3rem', fontSize: '1.3rem'}}>Thương hiệu</div>
            {suppliers.map((item) => {
              return <div style={{display: 'flex', alignItems: 'center', color: `${selectedSupplier == item.name ? 'coral' : 'black'}`}} className='filter-category' onClick={() => {handleSupplier(item.name)}}><div style={{fontSize: '2rem', display: 'flex', alignItems: 'center', height: '100%'}}>&#x2022;</div>{item.name}</div>
            })}
        </Space>
      </div>
      <div className='products-container'>
          {groupOfFour.length && groupOfFour.map((item) => {
            return(
              <div className='products-row'>
                {item.map(element => {
                    return (
                    <div className='product-card' onClick={() => {handleProductClick(element.id)}}>
                      <div className='home-product-image'><img className='product-image' src={`${BASE_URL}${element.imagePath}`} style={{width: 'auto', height: '100%', maxWidth: '100%'}} /></div>
                      <div className='product-name' style={{ display: 'flex', justifyContent: 'center' }}>{element.productName}</div>
                      <div className='product-price' style={{ display: 'flex', justifyContent: 'center', color: 'rgb(214, 81, 123)' }}>{USDollar.format(element.price)}</div>
                    </div>
                  )
                })}
              </div>
            )
          })}
      </div>
    </div>
  )
}
