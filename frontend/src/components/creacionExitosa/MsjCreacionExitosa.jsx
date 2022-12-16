import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCheckCircle } from "@fortawesome/free-solid-svg-icons";
import { Link } from 'react-router-dom';
import './creacionExitosa.css'


const MsjCreacionExitosa = () => {
  return (

    <div className="contenedorMensajeReserva">
      <div className="contenidoMensajeReserva">
        <FontAwesomeIcon icon={faCheckCircle} className="icono-verified" />
        <p>La propiedad se ha creado con éxito</p>
        <Link to="/">
          <button>ok</button>
        </Link>
      </div>
    </div>
  )
}

export default MsjCreacionExitosa