import axios from "axios"

export const getCustomers = async (currentPage,size,token) =>{
    let response = await axios.get('http://localhost:8086/customerapp/getCustomers', {
          params: {
            pageno: currentPage-1,
            pagesize: size,
          },
          headers: {
            Authorization: `Bearer ${token}`
          }
        })
    return response
}


export const addCustomer = async (uname,password,fname,lname,email,token) =>{
    let response = await axios.post(`http://localhost:8086/customerapp/saveCustomer/${uname}/${password}/${fname}/${lname}/${email}`,{},{
        headers: {
          Authorization: `Bearer ${token}`
        }
      })
    return response
}

export const updateCustomer = async (customerid,uname,password,fname,lname,email,token) =>{
    await axios.put(`http://localhost:8086/customerapp/updateCustomer/${customerid}/${uname}/${password}/${fname}/${lname}/${email}`,{},{
      headers:{
        Authorization : `Bearer ${token}`
      }
    })
}

export const deleteCustomer = async (d,token) =>{
    let response = await axios.delete(`http://localhost:8086/customerapp/deleteCustomer/${d.customerid}`,{
      headers: {
        Authorization: `Bearer ${token}`
      }
    })
    return response
}