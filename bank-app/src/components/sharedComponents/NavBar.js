import React, { useState } from 'react'
import { useNavigate } from 'react-router'
import './NavBar.css'

const NavBar = ({role,username}) => {


    let navigation = useNavigate()

    const handleLogout = (e) => {
        e.preventDefault()
        localStorage.clear()
        navigation('/')
        return
    }

    const handleCustomer = (e) =>{
      e.preventDefault()
      navigation(`/customers/${username}`)
    }

    const handleAccounts = (e) => {
      e.preventDefault()
      navigation(`/accounts/${username}`)
    }

    const handleBanks = (e) =>{
      e.preventDefault()
      navigation(`/adminDashBoard/${username}`)
    }

    const handleAccount = (e) =>{
      e.preventDefault()
      navigation(`/customerDashBoard/${username}`)
    }

    const handleTransaction = (e) => {
      e.preventDefault()
      navigation(`/transactions/${username}`)
    }

    if(role == "admin"){
        return (
            <>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <div className="container-fluid">
            <a className="navbar-brand" href="#">Welcome, {username}</a>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navItems navbar-collapse" id="navbarSupportedContent">
             
              <ul className="navbar-nav  me-auto mb-2 mb-lg-0">
                <li className="navList">
                  <a className="nav-link active" aria-current="page" href="#" onClick={handleBanks}>Banks</a>
                </li>
                <li className="navList">
                <a className="nav-link active" href="#" onClick={handleCustomer}>Customers</a>
                </li>

                
                <li className="navList">
                  <a className="nav-link active" href="#" onClick={handleAccounts}>Accounts</a>
                </li>
              </ul>
              <form className="d-flex">
                <button className="btn btn-danger" type="submit" onClick={handleLogout}>Logout</button>
              </form>
            </div>
          </div>
        </nav>
            </>
          
          )
    }
  return (
    <>
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">Welcome, {username}</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navItems navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="navList">
          <a className="nav-link active" aria-current="page" href="#" onClick={handleAccount}>Account</a>
        </li>
        <li className="navList">
          <a className="nav-link active" href="#" onClick={handleTransaction}>Transaction</a>
        </li>
      </ul>
      <form className="d-flex">
        <button className="btn btn-danger" type="submit" onClick={handleLogout}>Logout</button>
      </form>
    </div>
  </div>
</nav>
    </>
  
  )
}

export default NavBar
