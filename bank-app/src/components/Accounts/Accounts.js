import React, { useEffect,useState } from 'react'
import NavBar from '../sharedComponents/NavBar'
import { useNavigate, useParams } from 'react-router'
import axios from 'axios'
import Table from '../sharedComponents/Table'
import { Button, Form, Modal } from 'react-bootstrap'
import Pagination from '../sharedComponents/Pagination'
import Error from '../sharedComponents/Error/Error'
import Swal from 'sweetalert2'
import { authenticateAdmin } from '../../services/Authentication'
import { addAccount, deleteAccount, getAccounts, updateAccount } from '../../services/AccountsApi'
import { getBanks } from '../../services/AdminDashBoardApi'
import { getCustomers } from '../../services/CustomersApi'

const Accounts = () => {

  const [show, setShow] = useState(false);
  const [modalshow, setModalShow] = useState(false);
  const handleModalClose = () => setModalShow(false);
  const handleClose = () => setShow(false);

  let username = useParams().username
  const token = localStorage.getItem("auth")
  const[data,setData] = useState([]) 
  const[accountnumber,setAccountnumber] = useState()
  const[balance,setBalance] = useState()
  const[bankid,setBankid]  = useState()
  const[customerid,setCustomerid] = useState()
  const[bankData, setBankData] = useState([])
  const[size1, setSize1] = useState(5)
  const[customerData,setCustomerData] = useState([])
  const[size2, setSize2] = useState(5)

   const [currentPage, setCurrentPage] = useState(1);
  const [size,setSize] = useState(5)
  const [totalPages, setTotalPages] = useState(0)

  const[dataError, setDataError] = useState({})

  const navigation = useNavigate()


  const authenticate =  () =>{
    if(!authenticateAdmin())
    navigation('/')
  }

  useEffect(() =>  {
    authenticate()
  },[])

  const getAllBanks = async () => {
    if(authenticateAdmin()){
    try {
      let response = await getBanks(currentPage,size1,token)
  
      setBankData(response.data.content)
      setBankid(response.data.content[0].bankid)
      setSize1(response.data.totalElements)
      
    } catch (error) {
      setDataError(error.response.data)
    }
  
  }
  }

  const getAllCustomers = async () => {
    if(authenticateAdmin()){
    try {
     let response =  await getCustomers(currentPage,size2,token)
      setCustomerData(response.data.content)
      setCustomerid(response.data.content[0].customerid)
      setSize2(response.data.totalElements)
    } catch (error) {
      setDataError(error.response.data)
    }
  }
  }


  const getAllAccounts = async () => {
    if(authenticateAdmin()){
    try {
    let response = await getAccounts(currentPage,size,token)
    setData(response.data.content)
    setCurrentPage(Math.min(currentPage,response.data.totalPages))
    setTotalPages(response.data.totalPages)
    } catch (error) {
      setDataError(error.response.data)
    }
  }
  }

  useEffect(() => {
    console.log("object")
      getAllAccounts()
    },[currentPage,size])

    useEffect(() =>{
      getAllBanks()
    },[size1])

    useEffect(() =>{
      getAllCustomers()
    },[size2])


    const handlePageChange = async (clickValue) => {
      if(clickValue == "prev" && currentPage != 1)
      setCurrentPage(currentPage - 1)
      if(clickValue == "next" && currentPage != totalPages)
      setCurrentPage(currentPage + 1)
  }

    const handleAddAccount = async() =>{
      if(typeof balance == "undefined" || balance == ''){
        Swal.fire({  
          title: "Fields are empty",
          text: "Please fill the fields",
          icon: "error",
          confirmButtonText: "OK", 
        });  
        return
      }

      if(balance < 500){
        Swal.fire({  
          title: "Low Balance",
          text: "Minimum Balance should be 500",
          icon: "error",
          confirmButtonText: "OK", 
        });  
        return
      }
      
    await addAccount(customerid,bankid,balance,token)
    Swal.fire({  
      title: "Account added successfully",
      icon: "success",
      confirmButtonText: "OK", 
    }).then(function() {
      window.location.reload(false)
    })  
    }

    const handleDelete = async (d) =>{
    await deleteAccount(d,token)
  Swal.fire({  
    title: "Account Deleted Successfully",
    icon: "success",
    confirmButtonText: "OK", 
  });  
  await getAllAccounts()

    }

    const handleUpdate = async (d) =>{

      setAccountnumber(d.accountnumber)
      setBankid(d.bankid)
      setBalance(d.balance)
      setCustomerid(d.customerid)
      setShow(true)

    }

    const update = async() =>{
      if(typeof balance == "undefined" || balance == ''){
        Swal.fire({  
          title: "Fields are empty",
          text: "Please fill the fields",
          icon: "error",
          confirmButtonText: "OK", 
        });  
        return
      }

      if(balance < 500){
        Swal.fire({  
          title: "Low Balance",
          text: "Minimum Balance should be 500",
          icon: "error",
          confirmButtonText: "OK", 
        });  
        return
      }
      await updateAccount(accountnumber,bankid,customerid,balance,token)
      Swal.fire({  
        title: "Account updated successfully",
        icon: "success",
        confirmButtonText: "OK", 
      }).then(function() {
        window.location.reload(false)
      }) 

    }

    let options1
    if(bankData.length > 0){
        let count = 0;
        options1 = bankData.map((d) =>{
        return(
            <>
          <option value={d.bankid}>{d.bankid}</option>
            </>
        )
        }
        )
    }

    let options2
    if(customerData.length > 0){
        let count = 0;
        options2 = customerData.map((d) =>{
        return(
            <>
          <option value={d.customerid}>{d.customerid}</option>
            </>
        )
        }
        )
    }

  const headers = ["A/C No.", "Balance", "Bank Id", "Customer Id"]
  const functions = [handleUpdate,handleDelete]
  const functionHeaders = ["Update","Delete"]
  return (
   <>
   <div className='background'>
   <NavBar role={"admin"} username={username}/>
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
  
     <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Fill the details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <Form.Group >
               <Form.Label>Select Bank Id</Form.Label>
              <Form.Control
              as="select"
              value={bankid}
              onChange={e => {
                setBankid(e.target.value) }}
              >
              {options1}
             </Form.Control>
      
               <Form.Label>Select Customer Id </Form.Label>
               <Form.Control
              as="select"
              value={customerid}
              onChange={e => {
                setCustomerid(e.target.value) }}
              >
              {options2}
             </Form.Control>
              <Form.Label>Balance </Form.Label>
              <Form.Control type="text" onChange={(e) => setBalance(e.target.value)} 
              value={balance}/>     
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Cancel
          </Button>
          <Button variant="primary" onClick={update}>
            Save
          </Button>
        </Modal.Footer>
      </Modal>

      <Button className='button' variant="primary" onClick={() => {
        setModalShow(true)
        setBankid(bankData[0].bankid)
        setCustomerid(customerData[0].customerid)
        setBalance('')
      }} style={{marginLeft:'45%'}}> Add New Account</Button>

      <Modal show={modalshow} onHide={handleModalClose}>
        <Modal.Header closeButton>
          <Modal.Title>Fill the details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <Form.Group >
              <Form.Label>Select Bank Id</Form.Label>
              <Form.Control
              as="select"
              value={bankid}
              onChange={e => {
                setBankid(e.target.value) }}
              >
              {options1}
             </Form.Control>
      
               <Form.Label>Select Customer Id </Form.Label>
               <Form.Control
              as="select"
              value={customerid}
              onChange={e => {
                setCustomerid(e.target.value) }}
              >
              {options2}
             </Form.Control>
              <Form.Label>Balance </Form.Label>
              <Form.Control type="text" onChange={(e) => setBalance(e.target.value)} 
              />     
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleModalClose}>
            Cancel
          </Button>
          <Button variant="primary" onClick={handleAddAccount}>
            Save
          </Button>
        </Modal.Footer>
      </Modal>
      </div>
   </>
  )
}

export default Accounts
