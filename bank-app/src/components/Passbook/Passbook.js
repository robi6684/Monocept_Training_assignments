import axios from 'axios'
import React, { useEffect, useState } from 'react'
import NavBar from '../sharedComponents/NavBar'
import { useNavigate, useParams } from 'react-router'
import Table from '../sharedComponents/Table'
import { Form } from 'react-bootstrap'
import Pagination from '../sharedComponents/Pagination'
import Error from '../sharedComponents/Error/Error'
import { authenticateCustomer } from '../../services/Authentication'
import { getTransactionsByAccount } from '../../services/PassbookApi'


const Passbook = () => {

    const [currentPage, setCurrentPage] = useState(1);
  const [size,setSize] = useState(5)
  const [totalPages, setTotalPages] = useState(0)
  const[dataError, setDataError] = useState({})
   const navigation = useNavigate()
    const authenticate =  () =>{
      if(!authenticateCustomer())
      navigation('/')
    }
  
    useEffect(() =>  {
      authenticate()
    },[])

    let username = useParams().username
    let accountnumber = useParams().accountnumber
    const token = localStorage.getItem("auth")
    const[data,setData] = useState([])
    const getTransactions = async() =>{
      if(authenticateCustomer()){
        try {
              let response = await getTransactionsByAccount(accountnumber,currentPage,size,token)
              setData(response.data.content)
              setCurrentPage(Math.min(currentPage,response.data.totalPages))
              setTotalPages(response.data.totalPages)
        } catch (error) {
            setDataError(error.response.data)
            
        }
      }
    }

    useEffect(() =>{
        getTransactions()
    },[currentPage,size])

    const handlePageChange = async (clickValue) => {
        if(clickValue == "prev" && currentPage != 1)
        setCurrentPage(currentPage - 1)
        if(clickValue == "next" && currentPage != totalPages)
        setCurrentPage(currentPage + 1)
    }

 
    const headers = ["Transaction Id", "Sender A/C No.", "Receiver A/C No.", "Amount", "Date", "Transaction Type"]
    const functions = []
    const functionHeaders = []
  return (
   <>
    <div className='background'>
   <NavBar role={"customer"} username={username}/>
   {Object.keys(dataError).length !==0 ?
     <><Error error={dataError}></Error></>:
     <>
     <div className='container'>
      <Pagination
           currentPage={currentPage}
           totalPages = {totalPages}
          onPageChange={handlePageChange}
          />
          <div className='selectBox'>
      <Form.Label>Items per page</Form.Label>
      <Form.Select size="sm"  className='box' aria-label="Default select example" onChange={(e) => {
      setSize(e.target.value)
    }} value={size}>
      <option value="5">5</option>
      <option value="10">10</option>
      <option value="15">15</option>
      <option value="25">25</option>
      <option value="50">50</option>
      <option value="100">100</option>
    </Form.Select>
    </div>
   <Table headers={headers} rowData={data} functions={functions} functionHeaders={functionHeaders}/>
   </div>
     </>
     }
  </div>
   </>
  )
}

export default Passbook
