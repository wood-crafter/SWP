import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:8089/api/'
axios.defaults.headers = {
  'Access-Control-Allow-Origin': '*',
  'Content-Type': 'application/json',
}

export const getRequest = async (url, params = null, token = null) => {
  if (token) {
    let config = {
      method: 'GET',
      maxBodyLength: Infinity,
      url: url,
      headers: { 
        'Authorization': 'Bearer ' + token
      },
    }
    if (params) {
      return await axios.request(config, params)
    }
    return await axios.request(config)
  }
  if (params) {
    return await axios.get(url, { params })
  }
  return await axios.get(url)
}

export const postRequest = async (url, data = null, token = null) => {
  if(token) {
    if (data) {
      let config = {
        method: 'POST',
        maxBodyLength: Infinity,
        url: url,
        headers: { 
          'Authorization': 'Bearer ' + token
        },
        data: JSON.stringify(data)
      }
      return await axios.request(config)
    }
    let config = {
      method: 'POST',
      maxBodyLength: Infinity,
      url: url,
      headers: { 
        'Authorization': 'Bearer ' + token
      },
    }
    return await axios.request(config)
  }
  if (data) {
    let config = {
      method: 'post',
      maxBodyLength: Infinity,
      url: url,
      data: JSON.stringify(data)
    }
    return await axios.request(config)
  }
  return await axios.post(url)
}