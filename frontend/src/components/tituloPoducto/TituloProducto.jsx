import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faAngleLeft } from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";
import'./tituloProducto.css'
import galeria from '../galeriaImagenes/galeriaImg.json'

const TituloProducto = ({id}) => {
  return (
    <div className='container-titulo-producto'>
      <div className='titulo-producto'>
      <div><p>{galeria[id].categoria}</p></div>
      <div><h3>{galeria[id].nombre}</h3>
      </div>
    </div>
    <div>
    <Link to={`/`} className="link-volver">
    <FontAwesomeIcon icon={faAngleLeft} className="iconoVolver" /> </Link>
   </div>
  
    </div>     


   
           
   
  );
}

export default TituloProducto


