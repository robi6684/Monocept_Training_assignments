import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate, useParams } from 'react-router'
import Swal from 'sweetalert2'
import './Login.css'
import { login } from '../../services/LoginApi'


const Login = () => {
    const [username,setUsername] = useState()
    const [password,setPassword] = useState()
    const [checkbox,setCheckbox] = useState(false)
    const navigation = useNavigate()

    const checkRole = useParams().role;

    const handleMySubmit = async (e) =>{
        e.preventDefault()
        console.log(username)
        if(typeof username === 'undefined' || username === '' || typeof password === 'undefined'
        || password === ''){
            Swal.fire({  
                title: "Fields are empty",
                text: "Please fill the fields",
                icon: "error",
                confirmButtonText: "OK", 
              });  
              return;
        }
        let response;
        try {
           response = await login(username,password)
        } catch (error) {
            Swal.fire({  
                title: "Invalid Login Credentials",
                text: "Please enter correct username and password",
                icon: "error",
                confirmButtonText: "OK", 
              }); 
              return;   
        }
      
        let token = response.data.accessToken
        let role = response.data.rolename
        localStorage.setItem("auth",token)
        localStorage.setItem("role",role)

        if(checkRole === 'admin' && role === "ROLE_ADMIN"){
            navigation(`/adminDashBoard/${username}`)
            return
        }

        if(checkRole === 'admin' && role === "ROLE_CUSTOMER"){
            Swal.fire({  
                title: "Invalid Login Credentials",
                text: "Please enter correct username and password",
                icon: "error",
                confirmButtonText: "OK", 
              }); 
              return;   
        }

        if(checkRole === 'customer' && role === "ROLE_CUSTOMER"){
            navigation(`/customerDashBoard/${username}`)
            return;
        }

        if(checkRole === 'customer' && role === "ROLE_ADMIN"){
            Swal.fire({  
                title: "Invalid Login Credentials",
                text: "Please enter correct username and password",
                icon: "error",
                confirmButtonText: "OK", 
              }); 
              return;   
        }

        

    }
  return (
    <>
    <div className='divStyle'>
    <form>
    <div className="mb-3">
        <label class="form-label">Username</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" 
        onChange={(e) => setUsername(e.target.value)}
        value={username}
        />
    </div>
    <div className="mb-3">
        <label  class="form-label">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" 
        onChange={(e) => setPassword(e.target.value)}
        value={password}
        />
    </div>
    <div className="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1"
        
        onClick={(e) => setCheckbox((prev) => !prev)}
        checked={checkbox}
        />
        <label class="form-check-label" >Remember Me</label> 
    </div>
    <button type="submit" className='button' onClick={handleMySubmit}>Submit</button><br/>
    </form>
    </div>
    </>
  )
}

export default Login
