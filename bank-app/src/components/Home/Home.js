import React, { useEffect } from 'react'
import { useNavigate } from 'react-router'
import logo from '../../assets/images/logo.png'
import banner from '../../assets/images/banner.jpg'
import bikeLoan from '../../assets/images/Bike Loan.jpg'
import fixedDeposit from '../../assets/images/Fixed Deposit.jpg'
import healthInsurance from '../../assets/images/Health Insurance.jpg'
import homeLoan from '../../assets/images/Home Loan.jpg'
import creditCard from '../../assets/images/Credit Card.jpg'
import debitCard from '../../assets/images/Debit Card.jpg'
import './Home.css'

const Home = () => {
    const navigation = useNavigate()

    const clearLocalStorage = () =>{
        localStorage.clear()
    }

    useEffect(() => {
        clearLocalStorage()
    },[])

    const handleAdminLogin = () =>{
        
        navigation(`/login/${"admin"}`)
    }

    const handleCustomerLogin = () =>{
        navigation(`/login/${"customer"}`)
    }
  return (
   <>
   <nav className="navbar navbar-expand-lg bg-light">
        <div className="container-fluid">
          <a className="navbar-brand" href="#"><img className="img-fluid" src={logo}/></a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav mt-2">
              <li className="nav-item ">
                <p className="nav-link px-5" aria-current="page" href="#">About Us</p>
              </li>
              <li className="nav-item">
                <p className="nav-link px-5" href="#" >Offers</p>
              </li>
              <li className="nav-item">
                <p className="nav-link px-5" href="#">New Account</p>
              </li>
              <li className="nav-item">
                <p className="nav-link px-5" href="#">Life Insurance</p>
              </li>
              <li className="nav-item">
                <p className="nav-link px-5" href="#">Fixed Deposits</p>
              </li>
              <li className="nav-item">
                <p className="nav-link px-5" href="#">Contact</p>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <header className="text-center my-5">
        <img  src={banner}/>
    </header>
    {/* <!--LOGIN SECTION-->
    <!--##########################################################################--> */}
    <div className="container login" >
        <div className="row text-center py-5" >
            <div className="col-lg-6 col-md-12">
                <h1>For Admin</h1>
                <p>HDFC Bank is one of India leading private banks since 1994</p>
                <button className="button-71" onClick={handleAdminLogin}>Login</button>
                
            </div>
            <div className="col-lg-6 col-md-12">
                <h1>For Customers</h1>
                <p>Join over 21 million customers, get extra benefits and features </p>
                <button className="button-71" onClick={handleCustomerLogin}>Login</button>
            </div>
        </div>
    </div>

    <section class="pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h3 class="mb-3">Latest Offers </h3>
                </div>
                <div class="col-6 text-right">
                </div>
                <div class="col-12">
                    <div id="carouselExampleIndicators2" class="carousel slide" data-ride="carousel">
    
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="row">
    
                                    <div class="col-md-4 mb-3">
                                        <div class="card">
                                            <img class="img-fluid" alt="100%x280" src={fixedDeposit}/>
                                            <div className="card-body card-style2">
                                                <h4 class="card-title">Fixed Deposit</h4>
                                                <p class="card-text">Open HDFC fixed deposit at 8% Interest rate higher than others</p>
    
                                            </div>
    
                                        </div>
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <div class="card">
                                            <img class="img-fluid" alt="100%x280" src={bikeLoan}/>
                                            <div className="card-body card-style1">
                                                <h4 class="card-title">Special title treatment</h4>
                                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <div class="card">
                                            <img class="img-fluid" alt="100%x280" src={creditCard}/>
                                            <div class="card-body card-style3" >
                                                <h4 class="card-title">Special title treatment</h4>
                                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    
                                            </div>
                                        </div>
                                    </div>
    
                                </div>
                                <div class="row">
    
                                    <div class="col-md-4 mb-3">
                                        <div class="card">
                                            <img class="img-fluid" alt="100%x280" src={debitCard}/>
                                            <div className="card-body card-style2">
                                                <h4 class="card-title" >Special title treatment</h4>
                                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>

                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <div class="card">
                                            <img class="img-fluid" alt="100%x280" src={homeLoan}/>
                                            <div className="card-body card-style1">
                                                <h4 class="card-title">Special title treatment</h4>
                                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <div class="card">
                                            <img class="img-fluid" alt="100%x280" src={healthInsurance}/>
                                            <div className="card-body card-style3">
                                                <h4 class="card-title">Special title treatment</h4>
                                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="carousel-item">
                              
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div className="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <img src={logo} class="mt-5"/>
                </div>
                <div className="col-lg-3 my-4 footerText">
                    <div className='labels'>Fixed Depsoit</div>
                    <div class="mt-3 labels">Home Loans</div>
                    <div class="mt-3 labels">Credit Cards</div>
                    <div class="mt-3 labels">Life Insurance</div>
                </div>
                <div className="col-lg-3 my-4 footerText">
                    <div className='labels'>Our Branches</div>
                    <div class="mt-3 labels">Our Customers</div>
                    <div class="mt-3 labels">Our Clients</div>
                </div>
                <div className="col-lg-2 my-4 footerText">
                    <div className='labels'>About Us</div>
                    <div class="mt-3 labels">Contact Us</div>
                </div>
            </div>
        </div>
    </div>
   </>
    )
}

export default Home
