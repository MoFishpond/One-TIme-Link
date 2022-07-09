import './App.css';
import 'antd/dist/antd.min.css';

import CreateLinkView from './CreateLinkView/index.tsx';
import MessageView from './MessageView/index.tsx';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<CreateLinkView />} />
          <Route path="/private/*" element={<MessageView />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
