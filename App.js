import React from 'react';
import Navbar from "./components/Navbar/Navbar";
import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Home from './pages/Home/Home';
import Services from './pages/Services/Services';
import Product from './pages/Product/Product';
import ContactUs from './pages/ContactUs/ContactUs';

function App() {
  return (
    <Router>
      <Navbar />
      <Switch>
        <Route path='/home' component={Home} />
        <Route path='/services' component={Services} />
        <Route path='/product' component={Product} />
        <Route path='/contact-us' component={ContactUs} />
      </Switch>
    </Router>
  );
}

export default App;
