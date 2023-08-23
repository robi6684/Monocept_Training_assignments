import axios from "axios"

export const getCustomerAccounts = async (username,currentPage,size,token) =>{
    let response = await axios.get(`http://localhost:8086/customerapp/getAccounts/${username}`,{
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