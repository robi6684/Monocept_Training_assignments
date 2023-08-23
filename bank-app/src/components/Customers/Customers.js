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
import { addCustomer, deleteCustomer, getCustomers, updateCustomer } from '../../services/CustomersApi'
import './Customers.css'

const Customers = () => {

  const [show, setShow] = useState(false);
  const [modalshow, setModalShow] = useState(false);
  const handleModalClose = () => setModalShow(false);
  const handleClose = () => setShow(false);

    let username = useParams().username
    const token = localStorage.getItem("auth")
    const[data,setData] = useState([]) 
    const[uname,setUsername] = useState()
    const[password,setPassword] = useState()
    const[fname,setFirstname] = useState()
    const[lname,setLastname] = useState()
    const[email,setEmail] = useState()
    const[customerid,setCustomerid] = useState()

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



    const getAllCustomers = async () => {
      if(authenticateAdmin()){
      try {
        let response = await getCustomers(currentPage,size,token)
        setData(response.data.content)

        setCurrentPage(Math.min(currentPage,response.data.totalPages))
        setTotalPages(response.data.totalPages)
        
      } catch (error) {
       setDataError(error.response.data)
      }
    }
   
    }

    useEffect(() => {
        getAllCustomers()
      },[currentPage,size])


    const handlePageChange = async (clickValue) => {
    if(clickValue == "prev" && currentPage != 1)
    setCurrentPage(currentPage - 1)
    if(clickValue == "next" && currentPage != totalPages)
    setCurrentPage(currentPage + 1)
}



    const  handleAddCustomer = async() =>{
      if(typeof uname === 'undefined' || uname === '' || typeof password === 'undefined'
    || password === '' || typeof fname === 'undefined' || fname === '' || typeof lname === 'undefined'
    || lname === '' || typeof email === 'undefined'
    || email === ''){
        Swal.fire({  
            title: "Fields are empty",
            text: "Please fill the fields",
            icon: "error",
            confirmButtonText: "OK", 
          });  
          return;
    }
    try {
      await addCustomer(uname,password,fname,lname,email,token)
      Swal.fire({  
        title: "Customer Added Successfully",
        icon: "success",
        confirmButtonText: "OK", 
      }).then(function() {
        window.location.reload(false)
      }); 
    } catch (error) {
      Swal.fire({  
        title: "User Already Exists",
        icon: "error",
        confirmButtonText: "OK", 
      });
    }
     

    }

    const handleDelete = async(d) =>{
    await deleteCustomer(d,token)
    Swal.fire({  
      title: "Customer Deleted Successfully",
      icon: "success",
      confirmButtonText: "OK", 
    });
    await getAllCustomers()

    }

    const handleUpdate = async(d) =>{
      setCustomerid(d.customerid)
      setUsername(d.username)
      setPassword("*********")
      setFirstname(d.firstname)
      setLastname(d.lastname)
      setEmail(d.email)
      setShow(true)

    }
    const update = async () =>{
      if(typeof uname === 'undefined' || uname === '' || typeof password === 'undefined'
    || password === '' || typeof fname === 'undefined' || fname === '' || typeof lname === 'undefined'
    || lname === '' || typeof email === 'undefined'
    || email === ''){
        Swal.fire({  
            title: "Fields are empty",
            text: "Please fill the fields",
            icon: "error",
            confirmButtonText: "OK", 
          });  
          return;
    }
    try {
      updateCustomer(customerid,uname,password,fname,lname,email,token)
    Swal.fire({  
      title: "Customer updated successfully",
      icon: "success",
      confirmButtonText: "OK", 
    }).then(function() {
      window.location.reload(false)
    });  

    } catch (error) {
      Swal.fire({  
        title: "Invalid Details",
        text: "User with this username or email already exists",
        icon: "error",
        confirmButtonText: "OK", 
      });
      
    }
      

    }


    const headers = ["Customer Id", "Username", "First Name", "Last Name", "Email"]
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
              <Form.Label>Username </Form.Label>
              <Form.Control type="text"  onChange={(e) => setUsername(e.target.value)}
              value={uname}/>     
              <Form.Label>Password</Form.Label>
              <Form.Control type="text" onChange={(e) => setPassword(e.target.value)} 
              value={password}/>   
              <Form.Label>First Name</Form.Label>
              <Form.Control type="text" onChange={(e) => setFirstname(e.target.value)} 
              value={fname}/> 
              <Form.Label>lastname </Form.Label>
              <Form.Control type="text" onChange={(e) => setLastname(e.target.value)} 
              value={lname}/> 
              <Form.Label>Email </Form.Label>
              <Form.Control type="text" onChange={(e) => setEmail(e.target.value)} 
              value={email}/>   
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
        setUsername('')
        setPassword('')
        setFirstname('')
        setLastname('')
        setEmail('')
        }} style={{marginLeft:'45%'}}> Add New Customer</Button>

      <Modal show={modalshow} onHide={handleModalClose}>
        <Modal.Header closeButton>
          <Modal.Title>Fill the details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <Form.Group >
        <Form.Label>Username </Form.Label>
              <Form.Control type="text"  onChange={(e) => setUsername(e.target.value)}
              />     
              <Form.Label>Password</Form.Label>
              <Form.Control type="text" onChange={(e) => setPassword(e.target.value)} 
              />   
              <Form.Label>First Name</Form.Label>
              <Form.Control type="text" onChange={(e) => setFirstname(e.target.value)} 
              /> 
              <Form.Label>lastname </Form.Label>
              <Form.Control type="text" onChange={(e) => setLastname(e.target.value)} 
              /> 
              <Form.Label>Email </Form.Label>
              <Form.Control type="text" onChange={(e) => setEmail(e.target.value)} 
              />     
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleModalClose}>
            Cancel
          </Button>
          <Button variant="primary" onClick={handleAddCustomer}>
            Save
          </Button>
        </Modal.Footer>
      </Modal>
      </div>
   </>
  )
}

export default Customers
