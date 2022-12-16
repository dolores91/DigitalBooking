import React, { useContext } from 'react'
import TituloProducto from '../../components/tituloPoducto/TituloProducto'
import UbicacionProducto from '../../components/ubicacionProducto/UbicacionProducto';
import GaleriaImagenes from '../../components/galeriaImagenes/GaleriaImagenes';
import Descipcion from '../../components/descripcion/Descipcion';
import Caracteristicas from '../../components/caracteristicas/Caracteristicas';
import Calendario from '../../components/calendario/Calendario';
import { useParams } from 'react-router-dom';
import Politicas from '../../components/politicas/Politicas';
import "../../components/calendario/calendario.css"
import ContextUsuario from "../../context/UserContext"
import './producto.css'


const Producto = () => {

  const { handleClickProd } = useContext(ContextUsuario)

  const { id } = useParams()
  console.log(id);
  sessionStorage.setItem('idProducto', id);
  return (
    <div>
      <TituloProducto id={id} />
      <UbicacionProducto id={id} />
      <GaleriaImagenes id={id} />
      <Descipcion id={id} />
      <Caracteristicas />
      <div className='container-calendario'>
        <h3>Fechas disponibles</h3>
        <div className='calendario-producto'>
          <Calendario />
          <div className='card-reservar'>
            <p>Agrega tus fechas de viaje para obtener precios exactos</p>
            <button className='boton-reservar' onClick={handleClickProd}>Reservar</button>
          </div> </div></div>
      <Politicas />
    </div>
  )
}

export default Producto