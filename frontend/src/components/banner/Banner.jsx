import React from "react";
//import ciudades from "./ciudades.json";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendarDays } from "@fortawesome/free-solid-svg-icons";
import { format } from "date-fns";
import "react-date-range/dist/styles.css"; 
import "react-date-range/dist/theme/default.css";
import "./banner.css";
import SeleccionCiudades from "../seleccionCiudades/SeleccionCiudades"
import CalendarioBanner from "../calendarioBanner/CalendarioBanner";


export const Banner = ({ciudad, setCiudad, onChange,startDate, endDate, setDateRange, onClick}) => {
  

  /*useEffect(() => {
    (async function () {
      const response = await axios.get("http://localhost:8080/api/v1/city");
      const jsonData = await response.data.response;
      setCiudades(jsonData);
      console.log("dataCiudad", ciudades);
    })();
  }, []);*/

 

  return (
    <div className="banner">
      <h1 className="titulo-banner">
        {" "}
        Busca ofertas en departamentos, casas y mucho más{" "}
      </h1>
      <div className="containerBloqueBuscador">
      <div className="buscador">

      <SeleccionCiudades onChange={onChange}/>

      </div>
     
      <div className="seleccion">
        <FontAwesomeIcon icon={faCalendarDays} className="iconoBuscador" />

        <CalendarioBanner 
          startDate={startDate}
          endDate={endDate}
          setDateRange={setDateRange}
        />
        </div>
        <div>

        <button className="botonBanner" onClick={onClick}>Buscar</button>
      </div>
    </div>
    </div>
  );
};
