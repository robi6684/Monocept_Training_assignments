export const authenticateUser = () => {
    let token = localStorage.getItem("auth")

    if(!token)
    return 

    return localStorage.getItem("role")
}

export const authenticateAdmin = () =>{
    return authenticateUser() === "ROLE_ADMIN"
}

export const authenticateCustomer = () =>{
    return authenticateUser() === "ROLE_CUSTOMER"
}