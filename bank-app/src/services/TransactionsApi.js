import axios from "axios"

export const makeDeposit = async (accountnumber,amount,token) =>{
    let response = await axios.post(`http://localhost:8086/transactionapp/makeCredit/${accountnumber}/${amount}`,{},{
        headers:{
            Authorization:`Bearer ${token}`
        }
    })
    return response
}

export const makeWithdraw = async (accountnumber,amount,token) =>{
    let response = await axios.post(`http://localhost:8086/transactionapp/makeDebit/${accountnumber}/${amount}`,{},{
        headers:{
            Authorization:`Bearer ${token}`
        }
    })
    return response
}

export const makeTransfer= async (accountnumber,receiveraccountnumber,amount,token) =>{
    let response = await axios.post(`http://localhost:8086/transactionapp/makeTransfer/${accountnumber}/${receiveraccountnumber}/${amount}`,{},{
        headers:{
            Authorization:`Bearer ${token}`
        }
    })
    return response
}
