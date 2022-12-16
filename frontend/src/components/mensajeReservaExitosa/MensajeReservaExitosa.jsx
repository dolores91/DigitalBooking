import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {faCheckCircle} from "@fortawesome/free-solid-svg-icons";
import { Link } from 'react-router-dom';
import './mensajeReservaExitosa.css'


const MensajeReservaExitosa= () => {
  return (

    <div className="contenedorMensajeReserva">
      <div className="contenidoMensajeReserva">
      <FontAwesomeIcon icon={faCheckCircle} className="icono-verified"/>
        <span className="agradecimiento">¡Muchas gracias!</span>
        <p>Su reserva se ha realizado con éxito</p>
        <Link to="/">
        <button>ok</button>
        </Link>
      </div>
    </div>
  )
}

export default MensajeReservaExitosa