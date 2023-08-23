import React from 'react'

const Error = ({error}) => {
    console.log(error)
  return (
    <div>
      Error Status : {error.status} <br></br>
      Error Body : {error.body}<br></br>
    </div>
  )
}

export default Error
