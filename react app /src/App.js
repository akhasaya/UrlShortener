import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ShortenUrl from './ShortenUrl';

function App() {
  return (
    <div className="App">
      <h1>Url Shortener (bitly) Application</h1>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ShortenUrl />} ></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
