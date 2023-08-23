import './App.css';
import { Route, Routes } from 'react-router';
import Login from './components/Login/Login';
import Home from './components/Home/Home';
import CustomerDashBoard from './components/CustomerDashBoard/CustomerDashBoard';
import Customers from './components/Customers/Customers';
import AdminDashBoard from './components/AdminDashBoard/AdminDashBoard';
import Accounts from './components/Accounts/Accounts';
import Transactions from './components/Transactions/Transactions';
import Passbook from './components/Passbook/Passbook';




function App() {

  return (
 
    <>
    <Routes>
      <Route path='/' element={<Home/>}></Route>
      <Route path='/login/:role' element={<Login/>}></Route>
      <Route path='/customerDashBoard/:username' element={<CustomerDashBoard/>}></Route>
      <Route path='/adminDashBoard/:username' element={<AdminDashBoard/>}></Route>
      <Route path='customers/:username' element={<Customers/>}></Route>
      <Route path='accounts/:username' element={<Accounts/>}></Route>
      <Route path='transactions/:username' element={<Transactions/>}></Route>
      <Route path='passbook/:accountnumber/:username' element={<Passbook/>}></Route>
    </Routes>

    </>
  );
}

export default App;
