import React, { useState, useEffect} from "react";
import "./categoria.css";
import axios from "axios";
import { useParams } from "react-router-dom";

export const Categoria = ({ idCategoria, setIdCategoria, onDoubleClick} ) => {

  const [categoria, setCategorias] = useState(null)
  

useEffect(() => {
  (async function () {
    const response = await axios.get("http://localhost:8080/api/v1/category");
    const jsonData = await response.data.response;
    setCategorias(jsonData)
    //console.log("dataCategoria", categoria);
  })();
}, []);


return (
    <div >
      <h2 className="tituloCategoria">Buscar por tipo de alojamiento</h2>
      <div className="containerCategoria">
      {categoria == null ? null :
<>
      {categoria.map((item) => (
        <div key={item.id} className="cardCategoria" onDoubleClick={(e)=>{onDoubleClick(item.id,e)}}>
        <img src={item.url} alt={item.title}></img>
          <p  className="nombreCategoria">{item.title}</p>
        </div>
        ))}
</>
}

      </div>
    </div>
  );
};
