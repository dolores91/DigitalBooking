import React, { useContext } from "react";
import logo from "./img/logodb.png";
import { Link } from "react-router-dom";
import "./header.css";
import { useLocation } from "react-router-dom";
import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import ContextUsuario from "../../context/UserContext";


const Header = () => {
    const { pathname } = useLocation();

    const navigate = useNavigate();
    const { userAuth, setuserAuth, isAdm, nombre, iniciales } = useContext(ContextUsuario)
    //const nomb = sessionStorage.getItem('nombre');
    //const nombre = nomb.slice(1,-1)
    //const inicial = sessionStorage.getItem('iniciales')
    //const iniciales = inicial.slice(1,-1)

 
    //const mail = JSON.parse(sessionStorage.getItem('mail'));
    //const password = JSON.parse(sessionStorage.getItem('password'));

    const buttonsView = {
        "/": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/Account": (
            <>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/LogIn": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
            </>
        ),
        "/Reserva/1": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/Reserva/2": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/Reserva/3": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/Reserva/4": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/Reserva/5": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/Reserva/6": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/Reserva/7": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/Reserva/8": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/producto/1": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/producto/2": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/producto/3": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/producto/4": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/producto/5": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/producto/6": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/producto/7": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/producto/8": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
         "/administracion": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
        "/creacionexitosa": (
            <>
                <Link to="/Account" className="link-header">
                    <Button className="buttonCuentaNavBar">
                        Crear cuenta
                    </Button>
                </Link>
                <Link to="/LogIn" className="link-header">
                    <Button className="buttonSesionNavBar">
                        Iniciar Sesión
                    </Button>
                </Link>
            </>
        ),
    };

    const handleIsAuthMenu = () => {
        if (userAuth) {
            if (isAdm) {
                return (
                    <div className="bienvenida">
                        <div>
                            <Link className="adm" to="/administracion" >Administración</Link></div>
                            <div className= "vertical"></div>

                        <div className="circulo" >
                            <span>
                                {iniciales}
                            </span>
                        </div>
                        <div className="saludo">
                            <p className="hola">Hola,</p>
                            <p className="nombre">{nombre}</p>
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
                                {iniciales}
                            </span>
                        </div>
                        <div className="saludo">
                            <p className="hola">Hola,</p>
                            <p className="nombre">{nombre}</p>
                        </div>
                        <div className="close">
                            <button className="btnX" onClick={handleClick} > x   </button></div>
                    </div>
                );
            }

        } else {
            return buttonsView[pathname];
        }
    };
    const handleClick = () => {
        setuserAuth(false);
        navigate("/");
    };

    return (
        <nav>
            <div className="navbar">
                <div className="navbar-brand">
                    <a href="/" className="navbarlogo">
                        <img src={logo} alt="Logo" />
                    </a>
                    <p className="parrafoNavBar">Sentite como en tu hogar</p>
                </div>
                <div className="botonesNavBar">
                    {handleIsAuthMenu()}
                </div>
            </div>
        </nav>
    );
};

export default Header;

