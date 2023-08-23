import axios from 'axios'
export const getBanks = async (currentPage,size,token) =>{
    let response = await axios.get('http://localhost:8086/bankapp/getBanks',
      {
        params: {
          pageno: currentPage-1,
          pagesize: size,
        },
        headers: {
          Authorization: `Bearer ${token}`
        }
      }
    
     )
     return response
}

export const deleteBank = async (d,token) =>{
    let response = await axios.delete(`http://localhost:8086/bankapp/deleteBank/${d.bankid}`,{
      headers: {
        Authorization: `Bearer ${token}`
      }
    })
    return response
}

export const updateBank = async (bankid,bankname,abbrevation,token) =>{
    let response = await axios.post(`http://localhost:8086/bankapp/updateBank/${bankid}/${bankname}/${abbrevation}`,{},{
        headers:{
          Authorization : `Bearer ${token}`
        }
      })

      return response
}

export const addBank = async (bankname,abbrevation,token) =>{
    let response = await axios.post('http://localhost:8086/bankapp/saveBank',{
        bankname,
        abbrevation
      },{
        headers: {
          Authorization: `Bearer ${token}`
        }
      })

      return response
}