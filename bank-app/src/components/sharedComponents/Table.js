import React from 'react'
import { Button } from 'react-bootstrap'
import './Table.css'

const Table = ({headers,rowData,functions, functionHeaders,}) => {
    let i = -1;

    const array = []
    for(let i=0; i<headers.length; i++){
      array.push(headers[i])
    }
    for(let i=0; i<functionHeaders.length; i++){
      array.push(functionHeaders[i])
    }

    console.log(array)
    const tableHeaderElements = array.map(h => {
        return (
            <th scope='col'> {h}</th>
        )
    })

    const buttonColor = () =>{
      let val = i;
      if(val+1 >= functionHeaders.length)
      val=-1
      if(val+1 == 0)
      return "success"
      
      return "danger"
    }

    const rowDataElements = rowData.map((row) =>{
        
        const getButtonText = () =>{
          i++;
          if(i >= functionHeaders.length)
          i=0;
          return (
            functionHeaders[i]
            
          )
          
        }
        let value = Object.values(row)
        value = value.slice(0,headers.length)
        return(
            <tr>
                {
                    value.map(d =>{
                        return(
                            <td>{d}</td>
                        )
                    })
                }
                {
                  functions.map(f => {
                    return(
                      <td><Button variant={buttonColor()} onClick={() => {f(row)}}>{getButtonText()}</Button></td>
                    )
                  })
                }
                
            </tr>
        )
        
    })
  return (
    
    <table className="table">
    <thead>
      <tr>
        {tableHeaderElements}
      </tr>
    </thead>
    <tbody>
      {rowDataElements}
    </tbody>
    </table>
  )
}

export default Table
