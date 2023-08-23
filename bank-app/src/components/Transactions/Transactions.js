import React, { useEffect, useState } from 'react'
import NavBar from '../sharedComponents/NavBar'
import { useNavigate, useParams } from 'react-router'
import { Button, Form, Modal, Card } from 'react-bootstrap'
import Error from '../sharedComponents/Error/Error'
import Swal from 'sweetalert2'
import { authenticateCustomer } from '../../services/Authentication'
import { getCustomerAccounts } from '../../services/CustomerDashBoardApi'
import { makeDeposit, makeTransfer, makeWithdraw } from '../../services/TransactionsApi'
import img1 from '../../assets/images/deposit.jpg'
import img2 from '../../assets/images/withdraw.jpg'
import img3 from '../../assets/images/transfer.jpeg'

const Transactions = () => {
    const token = localStorage.getItem("auth")
    let username = useParams().username;
    const[data,setData] = useState({})
    const[amount,setAmount] = useState()
    const[receiveraccountnumber,setReceiverAccountNumber] = useState()
    const[accountnumber,setAccountnumber] = useState()
    const[depositShow, setDepositShow] = useState(false)
    const[withdrawShow,setWithdrawShow] = useState(false)
    const[transferShow,setTransferShow] = useState(false)
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
    const handleShow = (d) =>{
      setAccountnumber(data[0].accountnumber)
      setAmount('')
      setReceiverAccountNumber('')
      if(d == "deposit")
      setDepositShow(true)
      
      else if(d == "withdraw")
      setWithdrawShow(true)
      
      else
      setTransferShow(true)
    }
    const handleClose = (d) =>{
      if(d == "deposit")
      setDepositShow(false)
      
      else if(d == "withdraw")
      setWithdrawShow(false)
      
      else
      setTransferShow(false)
    }
    
    const getAccounts = async () => {
      if(authenticateCustomer()){
      try {
        let response = await getCustomerAccounts(username,currentPage,size,token)
    
        setData(response.data.content)
        // setCurrentPage(Math.min(currentPage,response.data.totalPages))
        // setTotalPages(response.data.totalPages)
        setAccountnumber(response.data.content[0].accountnumber)
        setSize(response.data.totalElements)
        console.log(response)
        console.log(size)
      } catch (error) {
        setDataError(error.response.data)
      }
    }
      }

      useEffect(() =>{
        getAccounts()
        
    },[size])

    const deposit = async () =>{
      if(typeof amount == "undefined" || amount == ''){
        Swal.fire({  
          title: "Fields are empty",
          text: "Please fill the fields",
          icon: "error",
          confirmButtonText: "OK", 
        }); 
        return
      }
        await makeDeposit(accountnumber,amount,token)
        Swal.fire({  
          text: `Amount: ${amount} deposited successfully`,
          icon: "success",
          confirmButtonText: "OK", 
        }).then(function() {
          window.location.reload(false)
        });
       
        

    }

    const withdraw = async () =>{
      if(typeof amount == "undefined" || amount == ''){
        Swal.fire({  
          title: "Fields are empty",
          text: "Please fill the fields",
          icon: "error",
          confirmButtonText: "OK", 
        }); 
        return
      }
      try {
      await makeWithdraw(accountnumber,amount,token)
      Swal.fire({  
        text: `Amount: ${amount} withdrawn successfully`,
        icon: "success",
        confirmButtonText: "OK", 
      }).then(function() {
        window.location.reload(false)
      });
      } catch (error) {
        Swal.fire({  
          title: `Insufficeint Balance`,
          icon: "error",
          confirmButtonText: "OK", 
        });
      }
       

    }

    const transfer = async () =>{
      if(typeof amount == "undefined" || amount == ''){
        Swal.fire({  
          title: "Fields are empty",
          text: "Please fill the fields",
          icon: "error",
          confirmButtonText: "OK", 
        }); 
        return
      }

      if(accountnumber == receiveraccountnumber){
        Swal.fire({  
          title: "Invalid Receiver Account Number",
          text: "Please enter correct A/C No.",
          icon: "error",
          confirmButtonText: "OK", 
        }); 
        return
      }

      
      try {
        let response = await makeTransfer(accountnumber,receiveraccountnumber,amount,token)
        Swal.fire({  
          text: `Amount: ${amount} transferred successfully from A/C No. ${accountnumber} to A/C No. ${receiveraccountnumber}`,
          icon: "success",
          confirmButtonText: "OK", 
        }).then(function() {
          window.location.reload(false)
        });
      } catch (error) {
        console.log(error)
        Swal.fire({  
          text: error.response.data.body,
          icon: "error",
          confirmButtonText: "OK", 
        });
      }
      
        
    }

    let options
    if(data.length > 0){
        let count = 0;
        options = data.map((d) =>{
        return(
            <>
          <option value={d.accountnumber}>{d.accountnumber}</option>
            </>
        )
        }
        )
    }


  return (
    <>
    <NavBar role={"customer"} username={username}/>
    <div className='background'>
    {Object.keys(dataError).length !==0 ?
     <><Error error={dataError}></Error></>:
     <>
      <div style={{display:'flex',alignItems:'center',justifyContent:'center'}}>
    <div className="mx-3 mt-5">
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src={img1} />
      <Card.Body style={{display:'flex',alignItems:'center',justifyContent:'center',backgroundColor:'#51e4a7'}}>
        <Button className='button-71' variant="primary" onClick={() => handleShow("deposit")}>Deposit</Button>
      </Card.Body>
    </Card>
   
   
    
    <Modal show={depositShow} onHide={() => handleClose("deposit")}>
        <Modal.Header closeButton>
          <Modal.Title>Fill the details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <Form.Group >
            <Form.Label>Select Account</Form.Label>
              <Form.Control
              as="select"
              value={accountnumber}
              onChange={e => {
                setAccountnumber(e.target.value) }}
              >
              {options}
             </Form.Control>
              <Form.Label>Amount </Form.Label>
              <Form.Control type="text" onChange={(e) => setAmount(e.target.value)}
              value={amount} />     
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => handleClose("deposit")}>
            Cancel
          </Button>
          <Button variant="primary" onClick={deposit}>
            Submit
          </Button>
        </Modal.Footer>
        </Modal>
        </div>
        <div className="mx-3 mt-5">
        <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src={img2} style={{height:'10rem'}} />
      <Card.Body style={{display:'flex',alignItems:'center',justifyContent:'center',backgroundColor:'#51e4a7'}}>
        <Button className='button-71' variant="primary" onClick={() => handleShow("withdraw")}>Withdraw</Button>
      </Card.Body>
    </Card>
        
    <Modal show={withdrawShow} onHide={() => handleClose("withdraw")}>
        <Modal.Header closeButton>
          <Modal.Title>Fill the details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <Form.Group >    
        <Form.Label>Select Account</Form.Label>
              <Form.Control
              as="select"
              value={accountnumber}
              onChange={e => {
                setAccountnumber(e.target.value) }}
              >
              {options}
             </Form.Control> 
              <Form.Label>Amount </Form.Label>
              <Form.Control type="text" onChange={(e) => setAmount(e.target.value)}
              value={amount} />     
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => handleClose("withdraw")}>
            Cancel
          </Button>
          <Button variant="primary" onClick={withdraw}>
            Submit
          </Button>
        </Modal.Footer>
        </Modal>
        </div>
        <div className="mx-3 mt-5">
        
        <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src={img3} />
      <Card.Body style={{display:'flex',alignItems:'center',justifyContent:'center',backgroundColor:'#51e4a7'}}>
        <Button className='button-71' variant="primary" onClick={() => handleShow("transfer")}>Transfer</Button>
      </Card.Body>
    </Card>
    
    <Modal show={transferShow} onHide={() => handleClose("transfer")}>
        <Modal.Header closeButton>
          <Modal.Title>Fill the details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <Form.Group > 
        <Form.Label>Select Account</Form.Label>
              <Form.Control
              as="select"
              value={accountnumber}
              onChange={e => {
                setAccountnumber(e.target.value) }}
              >
              {options}
             </Form.Control>
              <Form.Label>Receiver A/C No. </Form.Label>
              <Form.Control type="text" onChange={(e) => setReceiverAccountNumber(e.target.value)}
              value={receiveraccountnumber} />     
              <Form.Label>Amount </Form.Label>
              <Form.Control type="text" onChange={(e) => setAmount(e.target.value)}
              value={amount} />     
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => handleClose("transfer")}>
            Cancel
          </Button>
          <Button variant="primary" onClick={transfer}>
            Submit
          </Button>
        </Modal.Footer>
        </Modal>
        </div>
    </div> 


     
     </>

     }
    
   </div>
     
    </>
  )
}

export default Transactions
