import { Input, Button } from 'antd';
import React from 'react';
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import {BACKEND} from "../../constants.ts";

const { TextArea } = Input;



export const InputArea: React.FC = () => {
  let [content, setContent] = React.useState("")
  const navigate = useNavigate();

  const onChange = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
    console.log('Change:', e.target.value)
    setContent(e.target.value)
  };
  
  const handleClickGenerateLink = async () => {
    console.log('get' + content)
    await submitContent()
  }

  const submitContent = async () => {
    // navigate('/private/testurl')
    const response = await axios.post(BACKEND + '/generate', {
      content: content
    })
    console.log("submit")
    const url = '/private/' + response.data.oneTimeURL
    navigate(url);
  }
  return (
    <>
      <TextArea 
        showCount 
        maxLength={100} 
        style={{ height: 120 }} 
        onChange={onChange} 
      />
      <Button type="primary" onClick={handleClickGenerateLink}>Generate Link</Button>
    </>
  )
}

export default InputArea