import { Button } from 'antd';
import React from 'react';
import axios from 'axios';
import {BACKEND} from "../../constants.ts";



export const MessageArea: React.FC = () => {
  let [message, setMessage] = React.useState("")
  let [showMessage, setShowMessage] =  React.useState(false)
  const pathList = window.location.pathname.split('/')
  const path = pathList[2]
  console.log(path)
  
  const handleViewMessage = async () => {
    console.log('get')
    await getMessage()
  }

  const getMessage = async () => {
    console.log("submit")
    // setMessage('pp')
    // setShowMessage(true)
    const response = await axios.get(BACKEND + '/query?oneTimeURL='+path)
    const message = response.data.content
    setMessage(message)
    setShowMessage(true)
  }
  return (
    <div> 
      {!showMessage &&
        <div>
          <div>This message will self destruct!</div> 
          <Button type="primary" onClick={handleViewMessage} >View Message</Button>
        </div>
      }
      {
        showMessage &&
        <div>{message}</div>
      }
    </div>
  )
}

export default MessageArea