import React, {useState} from 'react';
import FormProducto from '../../components/administracion/FormProducto';
import Titulo from '../../components/administracion/Titulo';
import "./administracion.css"

const Administracion = () => {
    const [ciudad, setCiudad] = useState(null);
    const [categoria, setCategoria] = useState(null);
    return (
        <div>
           <Titulo></Titulo>
           <FormProducto ciudad={ciudad} setCiudad={setCiudad} categoria={categoria} setCategoria={setCategoria}></FormProducto>
        </div>
    );
}

export default Administracion;

