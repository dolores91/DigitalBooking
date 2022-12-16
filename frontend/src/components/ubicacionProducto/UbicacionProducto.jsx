import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faLocationDot } from "@fortawesome/free-solid-svg-icons";
import { faStar } from "@fortawesome/free-solid-svg-icons";
import './ubicacionProducto.css'
import galeria from '../galeriaImagenes/galeriaImg.json'

const UbicacionProducto = ({id}) => {
  return (
    <div className='container-ubicacion-producto'>
    <div className='ubicacion-producto'>
    <FontAwesomeIcon icon={faLocationDot} className="iconoBuscador" />  
    <div><p>{galeria[id].direccion}</p>
    <p>{galeria[id].detalleUbicacion}</p></div>
    </div>
    <div className="calificacionProductos">
        <div className="contenedorEstrellasProducto">
          <dt style={{ fontWeight: "700" }}>Muy bueno</dt>
          <dd>
            <FontAwesomeIcon icon={faStar} className="estrella" />
            <FontAwesomeIcon icon={faStar} className="estrella" />
            <FontAwesomeIcon icon={faStar} className="estrella" />
            <FontAwesomeIcon icon={faStar} className="estrella" />
            <FontAwesomeIcon icon={faStar} className="estrella-vacia" />
          </dd>
        </div>
        <span className="puntaje">8</span>
      </div>
    </div>
  )
}

export default UbicacionProducto