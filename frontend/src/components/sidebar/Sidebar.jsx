import React, { useEffect, useState, useContext } from "react";
import { slide as Menu } from "react-burger-menu";
import "./sidebar.css";
import { Link, useLocation } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFacebook, faLinkedin, faTwitter, faInstagram } from "@fortawesome/free-brands-svg-icons";
import ContextUsuario from "../../context/UserContext";

const Sidebar = () => {
  const [isAuthenticatedMenu, setIsAuthenticatedMenu] = useState(false);
  const { userAuth, setuserAuth, isAdm, nombre, iniciales } = useContext(ContextUsuario);


  useEffect(() => setIsAuthenticatedMenu(userAuth), [userAuth]);
  const { pathname } = useLocation();
  const [windowWidth, setWindowWidth] = useState(window.innerWidth);
 

  useEffect(() => {
    function handleSize() {
      setWindowWidth(window.innerWidth);
    }
    window.addEventListener("resize", handleSize);
    return () => window.removeEventListener("resize", handleSize);
  });

  const handleClick = () => {
    setuserAuth({
      nombre: "",
      apellido: "",
      mail: "",
      id: null,
      auth: false,
      redirect: false,
      rol:"",
      ciudad: "",
    });
  };

  const buttonsView = {
    "/": (
      <>
        <Link to="/Account" className="buttonSideBarCuenta">
          Crear cuenta
        </Link>
        <Link to="/Login" className="buttonNavSideSesion">
          Iniciar Sesión
        </Link>
      </>
    ),
    "/reserva/1": (
      <>
        <Link to="/Account" className="buttonSideBarCuenta">
          Crear cuenta
        </Link>
        <Link to="/Login" className="buttonNavSideSesion">
          Iniciar Sesión
        </Link>
      </>
    ),
    "/Account": (
      <>
        <Link to="/Login" className="buttonNavSideSesion">
          Iniciar Sesión
        </Link>
      </>
    ),
    "/Login": (
      <>
        <Link to="/Account" className="buttonSideBarCuenta">
          Crear cuenta
        </Link>
      </>
    ),
    "/producto/1": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
              Crear cuenta
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
              Iniciar Sesión
          </Link>
      </>
  ),
  "/producto/2": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
              Crear cuenta             
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
              Iniciar Sesión   
          </Link>
      </>
  ),
  "/producto/3": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
              Crear cuenta  
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
              Iniciar Sesión
          </Link>
      </>
  ),
  "/producto/4": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
              Crear cuenta
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
              Iniciar Sesión
          </Link>
      </>
  ),
  "/producto/5": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
               Crear cuenta              
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
              Iniciar Sesión
          </Link>
      </>
  ),
  "/producto/6": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
              Crear cuenta
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
              Iniciar Sesión
          </Link>
      </>
  ),
  "/producto/7": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
              Crear cuenta              
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
              Iniciar Sesión
          </Link>
      </>
  ),
    "/administracion": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
              Crear cuenta
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
              Iniciar Sesión
          </Link>
      </>
    ),
    "/creacionexitosa": (
      <>
          <Link to="/Account" className="buttonSideBarCuenta">
              Crear cuenta
          </Link>
          <Link to="/LogIn" className="buttonNavSideSesion">
             Iniciar Sesión
          </Link>
      </>
  ),
  };

  const handleIsAuthMenu = () => {
    if (isAuthenticatedMenu) {
      if (isAdm) {
          return (
              <div className="bienvenida">
                  <div>
                      <Link className="adm" to="/administracion" >Administración</Link></div>
                      <div class= "vertical"></div>

                  <div className="circulo" >
                      <span>
                          DA
                      </span>
                  </div>
                  <div className="saludo">
                      <p className="hola">Hola,</p>
                      <p className="nombre">Dolores</p>
                  </div>
                  <div className="close">
                      <button className="btnX" onClick={handleClick} > x   </button></div>
              </div>
          );
      } else {
          return (
              <div className="bienvenida">

                  <div className="circulo" >
                      <span>
                          DA
                      </span>
                  </div>
                  <div className="saludo">
                      <p className="hola">Hola,</p>
                      <p className="nombre">Dolores</p>
                  </div>
                  <div className="close">
                      <button className="btnX" onClick={handleClick} > x </button></div>
              </div>
          );
      }

  } else {
      return buttonsView[pathname];
  }
};

  const handleAuthenticated = () => {
    if (isAuthenticatedMenu) {
      return (
        <div className="SidebarBienvenida">
          
         <span> {iniciales}</span>
         
          <p>Hola,</p>
         <p className="nombreCompletoMenu">{nombre}</p>
        </div>
      );
    } else {
      return <span className="menu">MENU</span>;
    }
  };

  return (
    <>
      {windowWidth <= 768 && (
        <Menu  right >
          <div className="upper-colored-box">{handleAuthenticated()}</div>
          <div className="menuConFooter">
            <div className="menu-main">{handleIsAuthMenu()}</div>
            <div>
              <>
                <a href="#">
                  <FontAwesomeIcon icon={faFacebook} className="redesSidebar" />
                </a>
                <a href="#">
                  <FontAwesomeIcon icon={faLinkedin} className="redesSidebar" />
                </a>
                <a href="#">
                  <FontAwesomeIcon icon={faTwitter} className="redesSidebar" />
                </a>
                <a href="#">
                  <FontAwesomeIcon icon={faInstagram} className="redesSidebar" />
                </a>
              </>
            </div>
          </div>
        </Menu>
      )}
    </>
  );
};

export default Sidebar;
