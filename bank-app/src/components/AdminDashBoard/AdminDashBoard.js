import axios from 'axios'
import React, { useEffect, useState } from 'react'
import NavBar from '../sharedComponents/NavBar'
import { useNavigate, useParams } from 'react-router'
import Table from '../sharedComponents/Table'
import { Button, Form, FormLabel, Modal } from 'react-bootstrap'
import Pagination from '../sharedComponents/Pagination'
import Error from '../sharedComponents/Error/Error'
import Swal from 'sweetalert2'
import { authenticateAdmin } from '../../services/Authentication'
import { addBank, deleteBank, getBanks, updateBank } from '../../services/AdminDashBoardApi'
import './AdminDashBoard.css'

const AdminDashBoard = () => {
  const [show, setShow] = useState(false);
  const [modalshow, setModalShow] = useState(false);
  const handleModalClose = () => setModalShow(false);
  const handleClose = () => setShow(false);

  let username = useParams().username
  const token = localStorage.getItem("auth")

  const[data,setData] = useState([])
  const[bankname,setBankname] = useState()
  const[abbrevation,setAbbrevation] = useState()
  const[bankid,setBankid] = useState()

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
    let token = localStorage.getItem("auth")
    if(authenticateAdmin()){
    try {   
      let response = await getBanks(currentPage,size,token)
      setData(response.data.content)
      setCurrentPage(Math.min(currentPage,response.data.totalPages))
      setTotalPages(response.data.totalPages)
    
    } catch (error) {
      setDataError(error.response.data)
    }
   
  }

  }

  useEffect(() =>{
    getAllBanks()
  },[currentPage,size])

  const handlePageChange = async (clickValue) => {
    if(clickValue == "prev" && currentPage != 1)
    setCurrentPage(currentPage - 1)
    if(clickValue == "next" && currentPage != totalPages)
    setCurrentPage(currentPage + 1)
}




  const handleDelete = async (d) => {
    await deleteBank(d,token)
    Swal.fire({  
      title: "Bank Deleted Successfully",
      icon: "success",
      confirmButtonText: "OK", 
    });
    await getAllBanks()
  }

  const handleUpdate = async (d) => {
    setBankid(d.bankid)
    setAbbrevation(d.abbrevation)
    setBankname(d.bankname)
    setShow(true)

  
  }

  const update = async () => {
    if(typeof bankname === 'undefined' || bankname === '' || typeof abbrevation === 'undefined'
    || abbrevation === ''){
        Swal.fire({  
            title: "Fields are empty",
            text: "Please fill the fields",
            icon: "error",
            confirmButtonText: "OK", 
          });  
          return;
    }
    try {
     await updateBank(bankid,bankname,abbrevation,token)
  
      Swal.fire({  
        title: "Bank updated successfully",
        icon: "success",
        confirmButtonText: "OK", 
      }).then(function() {
        window.location.reload(false)
      });  
    } catch (error) {
      Swal.fire({  
        title: "Invalid Details",
        text: "Bank with these details already exists",
        icon: "error",
        confirmButtonText: "OK", 
      });
    }
  
  }

  const handleAddBank = async () =>{
    
    if(typeof bankname === 'undefined' || bankname === '' || typeof abbrevation === 'undefined'
    || abbrevation === ''){
        Swal.fire({  
            title: "Fields are empty",
            text: "Please fill the fields",
            icon: "error",
            confirmButtonText: "OK", 
          });  
          return;
    }
    try {
      await addBank(bankname,abbrevation,token)
      Swal.fire({  
        title: "Bank Added Successfully",
        icon: "success",
        confirmButtonText: "OK", 
      }).then(function() {
        window.location.reload(false)
      });  
      
    } catch (error) {
      Swal.fire({  
        title: "Bank Already Exists",
        icon: "error",
        confirmButtonText: "OK", 
      });
      
    }
   
    
    
  }

  const headers = ["Id", "Bank Name", "Abbrevation"]
  const functions = [handleUpdate,handleDelete]
  const functionHeaders = ["Update","Delete"]

  
  return (
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
      <Form.Select size="sm" className='box' aria-label="Default select example" onChange={(e) => {
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

   
    {/* <input type="text" onChange={(e) => {
      setSize(e.target.value)
    }} value={size}></input> */}
    <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Fill the details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <Form.Group >
              <Form.Label>Bank Name </Form.Label>
              <Form.Control type="text"  onChange={(e) => setBankname(e.target.value)}
              value={bankname}/>     
              <Form.Label>Abbrevation</Form.Label>
              <Form.Control type="text" onChange={(e) => setAbbrevation(e.target.value)} 
              value={abbrevation}/>       
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
        setAbbrevation('')
        setBankname('')
      }} style={{marginLeft:'45%'}}> Add New Bank</Button>

      <Modal show={modalshow} onHide={handleModalClose}>
        <Modal.Header closeButton>
          <Modal.Title>Fill the details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <Form.Group >
        <Form.Label>Bank Name </Form.Label>
              <Form.Control type="text"  onChange={(e) => setBankname(e.target.value)}
              />     
              <Form.Label>Abbrevation</Form.Label>
              <Form.Control type="text" onChange={(e) => setAbbrevation(e.target.value)} 
              />    
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleModalClose}>
            Cancel
          </Button>
          <Button variant="primary" onClick={handleAddBank}>
            Save
          </Button>
        </Modal.Footer>
      </Modal>

         
     
      </div>
  )
}

export default AdminDashBoard
