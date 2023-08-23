import axios from "axios"

export const getAccounts = async (currentPage,size,token) =>{
    let response = await axios.get('http://localhost:8086/accountapp/getAllAccounts',  {
    params: {
      pageno: currentPage-1,
      pagesize: size,
    },
    headers: {
      Authorization: `Bearer ${token}`
    }
  })

  return response;
}

export const addAccount = async (customerid, bankid, balance, token) =>{
    let response = await axios.post(`http://localhost:8086/accountapp/saveAccount/${customerid}/${bankid}/${balance}`,{},{
        headers: {
          Authorization: `Bearer ${token}`
        }
      })
      return response
}

export const deleteAccount = async (d,token) =>{
    let response = await axios.delete(`http://localhost:8086/accountapp/deleteAccount/${d.accountnumber}`,{
      headers: {
      Authorization: `Bearer ${token}`
    }
  }) 
  return response
}

export const updateAccount = async (accountnumber,bankid,customerid,balance,token) =>{
    await axios.put(`http://localhost:8086/accountapp/updateAccount/${accountnumber}/${bankid}/${customerid}/${balance}`,{},{
        headers:{
          Authorization : `Bearer ${token}`
        }
      })
}