import React from 'react';
import "./titulo.css"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faAngleLeft } from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";


const Titulo = () => {
    return (
        <div className='container-titulo-producto'>
            <div className='titulo-producto'>
            <h3 className='titulo-prod'>Administración de productos</h3>
            </div>
            <div>
                <Link to={`/`} className="link-volver">
                    <FontAwesomeIcon icon={faAngleLeft} className="iconoVolver" /> </Link>
            </div>
        </div>
    );
}

export default Titulo;
