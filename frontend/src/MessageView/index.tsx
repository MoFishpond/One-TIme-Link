import React from 'react';
import { Layout, Typography } from 'antd';
import MessageArea from './component/MessageArea.tsx';

const { Header, Content, Footer } = Layout;
const { Title } = Typography;

const headStyle = {
  color: 'white'
}

const MessageView: React.FC = () => {
  

  return (
    <>
      <Layout className="layout">
        <Header>
          <Title style={headStyle}>One Time Link</Title>
        </Header>
        <Content style={{ padding: '0 50px' }}>
          <MessageArea />
        </Content>
        <Footer style={{ textAlign: 'center' }}>@Mofish</Footer>
      </Layout>
    </>
  )
}

export default MessageView;