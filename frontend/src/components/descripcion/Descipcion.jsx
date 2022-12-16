import React, { useState, useEffect } from "react";
import './descripcion.css'
import { useParams } from "react-router-dom";



const Descipcion = () => {

  const [dataDescripcion, setDataDescripcion] = useState({});
  const { id } = useParams();
  
  useEffect( () => {
    if (id) {
    fetch(`http://localhost:8080/api/v1/product/${id}`, {
    mode: 'cors',
    method: "GET",
    headers: {
        "content-Type" : "application/Json",
    }})
    .then((res)=>res.json())
    .then((res) => {
    
        setDataDescripcion(res.response);
    })
  }
  }, [id])

 return (
    <div className="descripcion">
      <h2 className="titulo-descripcion">{dataDescripcion.name}</h2>
      <p className="texto-descripcion"> {dataDescripcion.descriptionA}</p>
        
        <p className="texto-descripcion"> {dataDescripcion.descriptionB} </p>
        
        <p className="texto-descripcion"> {dataDescripcion.descriptionC}</p>
        <p className="texto-descripcion"> {dataDescripcion.descriptionD} </p>
        
     
    </div>
  )
 }
export default Descipcion;
