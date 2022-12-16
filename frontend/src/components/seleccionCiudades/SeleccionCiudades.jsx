import React, { useState, useEffect } from "react";
import "./seleccionCiudades.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faLocationDot } from "@fortawesome/free-solid-svg-icons";
import Select from "react-select";
import selectStyles from "./selectStyles";
import "./seleccionCiudades.css";
import axios from "axios";

export default function  SeleccionCiudades ({ onChange} ) {
    const [ciudades, setCiudades] = useState([]);
    useEffect( () => {
  
      (async function () {
        const response = await axios.get("http://localhost:8080/api/v1/city");
        const jsonData = await response.data.response;
        setCiudades(jsonData);
        //console.log("dataCiudad", ciudades);
      })();
    }, []);
  
  
    return (
      <div className="contenedorSelect">
        <Select
          placeholder={
            <div className="placeholderSelect">
              <FontAwesomeIcon
                icon={faLocationDot}
                style={{ marginRight: "4px" }}
              />
              ¿A dónde vamos?
            </div>
          }
          className="inputBanner"        
          options={ciudades.map((ciudad) => ({
            label: (
              <div className="contenedorLabel">
                <FontAwesomeIcon
                  icon={faLocationDot}
                  className="iconoLocacionLabel"
                />
                <div>
                  <dt>{ciudad.name}, {ciudad.country}</dt>               
                </div>              
              </div>
              
            ),
            value: ciudad.id,
          }))}
          styles={selectStyles}
          onChange={(e) => {
            onChange(e.value);
          }}
        />
      </div>
    )
  }
  