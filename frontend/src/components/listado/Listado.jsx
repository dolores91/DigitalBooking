import React, {useState,useEffect} from "react";
import "./listado.css";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar } from "@fortawesome/free-solid-svg-icons";


export const Listado = (props) => {

  const [listfilter, setListFilter] = useState(props.listado);

  useEffect(() => {
    if (props.selectCategoria) {
      console.log(props.listado.filter((data) => data.category.id === props.selectCategoria)      );
      setListFilter(
        props.listado.filter(
          (data) => data.category.id === props.selectCategoria
        )
      );
    }

  else if (props.selectCiudad) {
      console.log(
        props.listado.filter((data) => data.city.id === props.selectCiudad)
      );
      setListFilter(
        props.listado.filter(
          (data) => data.city.id  === props.selectCiudad
        )
      );
    }


  }, [props.listado, props.selectCategoria,props.selectCiudad]);


  useEffect(() => {
  // console.log({listfilter});
  }, [listfilter]);





  //console.log(id);
  return (
    <div className="listado">
      <h2 className="recomendaciones">Recomendaciones:</h2>
      <div className="cardContainer">
      {listfilter&&listfilter.length > 0 && listfilter.map((item) => (
          <div key={item.id} className="card">
            <div className="imagen">
              <img src={item.image[0].url} alt={item.image[0].title}></img>
            </div>
            <div className="detalle">
              <p className="categoria">{item.category.title}</p>
              <h4 className="nombreAlojamiento">{item.name}</h4>
              <p className="ubicacion">{item.location_detail}</p>
              <div className="contenedorEstrellasProducto">
          <dt style={{ fontWeight: "700" }} className="recomendacion-listado">Muy bueno</dt>
          <dd >
            <FontAwesomeIcon icon={faStar} className="estrella" />
            <FontAwesomeIcon icon={faStar} className="estrella" />
            <FontAwesomeIcon icon={faStar} className="estrella" />
            <FontAwesomeIcon icon={faStar} className="estrella" />
            <FontAwesomeIcon icon={faStar} className="estrella-vacia" />
          </dd>
        </div>

              <p className="descripcion">{item.descriptionA}</p>
              <Link
                to={`/producto/${item.id}`}
                className="link-listado"
              >
                <button className="buttonCard">Ver más</button>
            
              </Link>
              
            </div>
          </div>
        ))}
      </div>
      {/*setid(item.category.id)*/}

    </div>
  );
};