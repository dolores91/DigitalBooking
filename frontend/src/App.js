import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Home } from "./pages/home/Home.jsx";
import Producto from './pages/producto/Producto';
import LogIn from './pages/login/LogIn';
import Account from './pages/cuenta/Account';
import React from 'react';
import Footer from './components/footer/Footer.jsx';
import Header from './components/header/Header';
import Reserva from './pages/reserva/Reserva.jsx';
import { UserContext } from './context/UserContext.jsx';
import Sidebar from './components/sidebar/Sidebar.jsx';
import { ContextUsuario } from "./context/UserContext";

import ReservaExitosa from './pages/reservaExitosa/ReservaExitosa.jsx';
import Administracion from './pages/administracion/Administracion.jsx';
import CreacionExitosa from './pages/creacionExitosa/CreacionExitosa.jsx';


function App() {
  
  /*const [userAuth, setuserAuth] = useState(false);
  useEffect(() => {
    console.log(userAuth);
  }, [userAuth]);*/

  return (
    <>
      <BrowserRouter>
        <UserContext>
          <Header/>
          <Sidebar/>
          <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/producto/:id" element={<Producto/>} />
            <Route path="/LogIn" element={<LogIn/>} />
            <Route path="/Account" element={<Account/>} />
            <Route path="/Reserva/:id" element={<Reserva />} /> 
            <Route path="/reservaexitosa" element={<ReservaExitosa />} />
            <Route path='/administracion' element={<Administracion/>}/>
            <Route path='/creacionexitosa' element={<CreacionExitosa/>}/>
          </Routes>
          <Footer />
        </UserContext>
      </BrowserRouter>
    </>
  );
}
export default App;


/*<Route path="/producto/:id/reserva" element={<Reserva />} />  */