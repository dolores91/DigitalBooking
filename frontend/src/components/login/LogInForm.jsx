import React, { useContext, useState } from 'react';
import './logIn.css'
import { Link } from "react-router-dom";
import { useRef } from "react";
import "../../pages/home/Home";
import ContextUsuario from "../../context/UserContext";
import { loginApi } from '../signupLogin/SignupLogin';
import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faExclamationTriangle } from "@fortawesome/free-solid-svg-icons";


const LogInForm = () => {
    const { existeUsuario } = useContext(ContextUsuario)
    const { estaEnReserva } = useContext(ContextUsuario)
    const { tipoDeUsuario } = useContext(ContextUsuario)
    const { nombreHeader } = useContext(ContextUsuario)

    const email = useRef(null);
    const password = useRef(null);

    const [formularioValido, setFormularioValido] = useState(true);
    const navigate = useNavigate();

    const handleSubmitLogin = async (event) => {
        event.preventDefault();
        existeUsuario(email.current.value, password.current.value)
        tipoDeUsuario(email.current.value)
        nombreHeader(email.current.value)

        console.log({ email, password })

      //  if (email.valido && password.valido) {
            const responsePost = await loginApi({
                email: email.current.value,
                password: password.current.value,
            });
            if (responsePost) {
                existeUsuario({
                    name: responsePost.name,
                    surname: responsePost.surname,
                    email: responsePost.email,
                    id: responsePost.id,
                    auth: true,
                    redirect: false,
                    role: responsePost.role,
                });

                navigate("/")
            } else {

                setFormularioValido(false)
            }
        //}
       // console.log("formvalid: ", formularioValido)
    };
    return (
        <div className='container'>
            <Link to="/"><span className="material-symbols-outlined"> close</span></Link>

            <div className='flex-container'>

                <form onSubmit={handleSubmitLogin}>  <div>
                    <p className="LogicaBotonProd">{estaEnReserva ? ' ! Para realizar una reserva necesitas estar logueado' : ''}</p>
                </div>
                    <div className='tituloSI'>Iniciar Sesión</div>
                    <label className='labelSI'><div>
                        Correo Electronico:</div>
                        <div><input className='inputSI'
                            ref={email}
                            type="email"
                            name="mail" /></div>
                    </label>

                    <label className='labelSI'><div>
                        Contraseña:</div>
                        <div><input className='inputSI' ref={password} type="Password" name="password" /></div>
                    </label>

                    {formularioValido === false && (
                        <div className='mensajeError'>
                            <p>
                                <FontAwesomeIcon icon={faExclamationTriangle} />
                                Credenciales Inválidas
                            </p>
                        </div>
                    )}

                    <button className='btSI' >Ingresar</button>
                    <p className='textoSI' >¿Aún no tienes cuenta? <Link className='link' to="/Account" >Registrate</Link></p>
                </form>
            </div></div>
    );
}

export default LogInForm;
