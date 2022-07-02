import React from 'react';
import { Layout, Typography } from 'antd';
import InputArea from './component/InputArea.tsx';

const { Header, Content, Footer } = Layout;
const { Title } = Typography;

const headStyle = {
  color: 'white'
}

const CreateLinkView: React.FC = () => {
  

  return (
    <>
      <Layout className="layout">
        <Header>
          <Title style={headStyle}>One Time Link</Title>
        </Header>
        <Content style={{ padding: '0 50px' }}>
          <div className="site-layout-content">Content</div>
          <InputArea />
        </Content>
        <Footer style={{ textAlign: 'center' }}>@Mofish</Footer>
      </Layout>
    </>
  )
}

export default CreateLinkView;