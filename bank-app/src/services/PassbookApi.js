import axios from "axios";

export const getTransactionsByAccount = async (accountnumber,currentPage,size,token) =>{
    let response = await axios.get(`http://localhost:8086/accountapp/getTransactionsByAccount/${accountnumber}`,{
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