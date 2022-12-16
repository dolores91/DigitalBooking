import React, {useState,useEffect}from "react";
import "./caracteristicas.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faPersonSwimming,
  faWifi,
  faFan,
  faPaw,
  faTv,
  faMugSaucer,
  faParking,
  faMartiniGlass,
  faUtensils,
  faUmbrellaBeach,
  faSpa
} from "@fortawesome/free-solid-svg-icons";
import axios from "axios";
import { useParams } from "react-router-dom";

const Caracteristicas = () => {
 
  const [dataCaracteristicas, setDataCaracteristicas] = useState([]);
  const { id } = useParams();







  return (
    <div>
      <h3 className="titulo-caracteristicas">¿Que ofrece este lugar?</h3>

      <div className="container-caracteristicas">

     {/* {dataCaracteristicas.map((cat) => (
            <div key={cat.id} className="card-caracteristica">
              <span class="icono-card-caracteristica">{cat.icon}</span>
              <p>{cat.name}</p>
            </div>
          ))}*/}




     <div>
          <div className="card-caracteristica">
            <FontAwesomeIcon
              icon={faMugSaucer}
              className="icono-card-caracteristica"
            /> Desayuno
          </div>
          <div>
            <FontAwesomeIcon
              icon={faParking}
              className="icono-card-caracteristica"
            />
            Estacionamiento
          </div>
        </div>
        <div>
          <div className="card-caracteristica">
            <FontAwesomeIcon
              icon={faTv}
              className="icono-card-caracteristica"
            />
            Televisor
          </div>
          <div>
            <FontAwesomeIcon
              icon={faPersonSwimming}
              className="icono-card-caracteristica"
            />{" "}
            Pileta
          </div>
        </div>
        <div>
          <div className="card-caracteristica">
            <FontAwesomeIcon
              icon={faFan}
              className="icono-card-caracteristica"
            />
            Aire Acondicionado
          </div>
          <div>
            {" "}
            <FontAwesomeIcon
              icon={faWifi}
              className="icono-card-caracteristica"
            />{" "}
            Wifi
          </div>
        </div>

        <div className="card-caracteristica">
          <div>
            {" "}
            <FontAwesomeIcon
              icon={faPaw}
              className="icono-card-caracteristica"
            />{" "}
            Apto mascotas
      </div>
          </div>
        </div>
    </div>
  );
};

export default Caracteristicas;
