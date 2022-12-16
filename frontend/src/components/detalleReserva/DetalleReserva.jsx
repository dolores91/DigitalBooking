import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faLocationDot } from "@fortawesome/free-solid-svg-icons";
import { faStar } from "@fortawesome/free-solid-svg-icons";
import galeria from '../galeriaImagenes/galeriaImg.json';
import './detalleReserva.css'
import { Link } from "react-router-dom";


const DetalleReserva = ({id}) => {
  
  return (
    <div className="tablaDatos">
      <div className="contenedorTablaDetalle">
        <h2 className="tituloDetalleReserva">Detalle de la reserva</h2>
        <div className="contenidoTablaDetalle">
          <div>
            <img src={galeria[id].url[0] } alt={galeria[id].id} className="detalle-reserva-imagen" ></img>
          </div>

          <div className="contenedorDetalle">
            <p className='detalle-reverva-categoria'>{galeria[id].categoria}</p>
            <h3 className='detalle-reverva-nombre'>{galeria[id].nombre}</h3>
            <div className="contenedorEstrellas">
              <FontAwesomeIcon icon={faStar} className="estrella" />
              <FontAwesomeIcon icon={faStar} className="estrella" />
              <FontAwesomeIcon icon={faStar} className="estrella" />
              <FontAwesomeIcon icon={faStar} className="estrella" />
              <FontAwesomeIcon icon={faStar} className="estrella" />
            </div>
            <p className='detalle-reverva-ubicacion'>
              <FontAwesomeIcon icon={faLocationDot}  />
              {galeria[id].direccion}
            </p>
         <div className='fechas-check'> 
            <div className="check">
              <p>Check in</p>
              <p>24/12/2022</p>
            </div>
         
            <div className="check">
              <p>Check out</p>
              <p>27/12/2022</p>
            </div>
            </div>

            <div className='detalle-reserva-boton'>
            <Link to={`/reservaexitosa`} className="link-listado">
                     
           <button className="confirmarReserva">
              Confirmar reserva
            </button> </Link></div>
            
          </div>
        </div>
      </div>
    </div>
  );
  
}

export default DetalleReserva
