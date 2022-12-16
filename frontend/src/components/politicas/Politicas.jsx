import React, { useState, useEffect} from 'react'
import './politicas.css'
import { useParams } from 'react-router-dom';
import axios from 'axios';


const Politicas = () => {

  const [dataPoliticas, setDataPoliticas] = useState([]);
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
    
        setDataPoliticas(res.response);
        console.log(res.response);
    })
  }
  }, [id])
  
  /*useEffect( () => {

    (async function () {
      const response = await axios.get("http://localhost:8080/api/v1/product/&{id}");
      const jsonData = await response.data.response;
      setDataPoliticas(jsonData);
      console.log(dataPoliticas);
      })();
    }, []);*/

   
    /*useEffect(() => {
      console.log("politicas: ", dataPoliticas)
    }, [dataPoliticas])
   */
    
    /*fetch(`http://localhost:8080/api/v1/rule/${id}`, {
    mode: 'cors',
    method: "GET",
    headers: {
        "content-Type" : "application/Json",
    }})
    .then((res)=>res.json())
    .then((res) => {
        console.log( dataPoliticas )
        setDataPoliticas(res.response);
    })
  }, [])*/
  

  return (
    <div>
      <h3 className='titulo-politicas'>Qué tenés que saber</h3>
      <div className="contenedorTodasPoliticas">
        <div className="contenedorPoliticas">
          <div>
            <h4>Normas de la casa</h4>
          </div>
          <div className="listaPoliticas">
            <ul>
              <li>Check-out:10:00</li>
              <li>No se permiten fiestas</li>
              <li>No fumar</li>
            {/*dataPoliticas
            .filter((politica) => politica.productRule.rule.description === 1 && politica.producto?.id == id)
            .map((politica) => (
                <li key={politica.id}> {politica.productRule.rule.description} </li>
              ))*/}
            </ul>
            
          </div>
        </div>
        <div className="contenedorPoliticas">
          <div>
            <h4>Salud y Seguridad</h4>
          </div>
          <div className="listaPoliticas">
          <ul>
              <li>Se aplican las pautas de distanciamiento social y otras normas relacionadas con el corona virus</li>
              <li>Detector de humo</li>
              <li>Deposito de seguridad</li>
          </ul>           
          </div>
        </div>

        <div className="contenedorPoliticas">
          <div>
            <h4>Politicas de cancelación</h4>
          </div>
          <div className="listaPoliticas">
          <ul>
                <li>En caso de cancelación por cualquier otra razón que no tenga que ver con una imposición legal del gobierno quedará vigente la política de cancelación que el complejo tiene para sus reservas</li>
          </ul>
            
          </div>
        </div>
      </div>
    </div>
  );
}

export default Politicas