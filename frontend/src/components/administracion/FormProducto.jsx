import React, { useState, useEffect } from "react";
import "./formProd.css"
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useFormik } from 'formik';

const validate = values => {
  const errors = {};
  if (!values.nombreprop) {
    errors.nombreprop = 'Debe ingresar el nombre de la propiedad';
  }
  if (!values.direccion) {
    errors.direccion = 'Debe ingresar el domicilio de la propiedad';
  }
  if (!values.latitud) {
    errors.latitud = 'Debe ingresar la latitud de la propiedad';
  }
  if (!values.longitud) {
    errors.longitud = 'Debe ingresar la longitud de la propiedad';
  }
  if (!values.descripcionA) {
    errors.descripcionA = 'Debe describir la propiedad';
  }
  if (!values.descripcionB) {
    errors.descripcionB = 'Debe describir las habitaciones';
  }
  if (!values.descripcionC) {
    errors.descripcionC = 'Debe describir el desayuno';
  }
  if (!values.descripcionD) {
    errors.descripcionD = 'Debe describir el barrio';
  }
  if (!values.url1 || !values.titulo1 || !values.descripcion1) {
    errors.descripcion1 = 'Debe ingresar todos los datos de la foto';
  }
  if (!values.url2 || !values.titulo2 || !values.descripcion2) {
    errors.descripcion2 = 'Debe ingresar todos los datos de la foto';
  }
  if (!values.url3 || !values.titulo3 || !values.descripcion3) {
    errors.descripcion3 = 'Debe ingresar todos los datos de la foto';
  }
  if (!values.url4 || !values.titulo4 || !values.descripcion4) {
    errors.descripcion4 = 'Debe ingresar todos los datos de la foto';
  }
  if (!values.url5 || !values.titulo5 || !values.descripcion5) {
    errors.descripcion5 = 'Debe ingresar todos los datos de la foto';
  }

  return errors;
  ;
}

const FormProducto = ({ ciudad, setCiudad, categoria, setCategoria }) => {

  //POST DE PRODUCTO---------------------------------------------------------------
  const baseURL = "http://localhost:8080/api/v1/product";

  const [postP, setPostP] = useState(null);

  React.useEffect(() => {
    axios.get(`${baseURL}/1`).then((response) => {
      setPostP(response.data);
    });
  }, []);

  function createPost() {
    axios
      .post(baseURL, {
        "name": formik.values.nombreprop,
        "mainDescription": "En el corazon de Buenos Aires",
        "descriptionA": formik.values.descripcionA,
        "descriptionB": formik.values.descripcionB,
        "descriptionC": formik.values.descripcionC,
        "descriptionD": formik.values.descripcionD,
        "address": formik.values.direccion,
        "location_detail": "Excelente Ubicacion",
        "latitude": formik.values.latitud,
        "longitude": formik.values.longitud,
        "city":
        {
          "id": 2
        },
        "category":
        {
          "id": 2
        }
      })
      .then((response) => {
        setPostP(response.data);
      }); if (postP) {
        console.log(postP.response);//me sigue trayendo id1
      }

  }


  //POST DE IMAGENES------------------------------------------------------
  const baseURLi = "http://localhost:8080/api/v1/image";

  const [posti, setPosti] = useState(null);

  React.useEffect(() => {
    axios.get(`${baseURLi}/1`).then((response) => {
      setPosti(response.data);
    });
  }, []);

  function createPosti() {
    axios
      .post(baseURLi, {
        "title": formik.values.titulo1,
        "description": formik.values.descripcion1,
        "url": "https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/8-Ba%C3%B1o+TIERRA.jpg",
        "product_idproduct": postP.response.id
      })
      .then((response) => {
        setPosti(response.data);
      }); if (!posti) return "No post!"
  }


  const navigate = useNavigate();

  const formik = useFormik({
    initialValues: {
      nombreprop: '',
      categoria: '',
      direccion: '',
      latitud: '',
      longitud: '',
      descripcionA: '',
      descripcionB: '',
      descripcionC: '',
      descripcionD: '',
      url1: '',
      titulo1: '',
      descripcion1: '',
      url2: '',
      titulo2: '',
      descripcion2: '',
      url3: '',
      titulo3: '',
      descripcion3: '',
      url4: '',
      titulo4: '',
      descripcion4: '',
      url5: '',
      titulo5: '',
      descripcion5: '',


    },
    validate,
    validateOnChange: false,
    validateOnBlur: false,
    onSubmit: values => {
      //createPost()
      createPosti()
      navigate("/creacionexitosa")

    },
  })


  // SELECT CIUDADES DESDE LA API -->
  const [ciudades, setCiudades] = useState(null);
  useEffect(() => {
    (async function () {
      const response = await axios.get("http://localhost:8080/api/v1/city");
      const jsonData = await response.data.response;
      setCiudades(jsonData);
      //console.log("dataCiudad", ciudades);
    })();
  }, []);

  // SELECT CATEGORIAS DESDE LA API -->
  const [categorias, setCategorias] = useState(null);
  useEffect(() => {
    (async function () {
      const response = await axios.get("http://localhost:8080/api/v1/category");
      const jsonData = await response.data.response;
      setCategorias(jsonData);
      //console.log("dataCategorias", categorias);
    })();
  }, []);

  // console.log(categorias);


  return (
    <div className='containerProd'>
      <h2 className='tituloPN'>Crear producto</h2>
      <div className='prod-form'>
        <form onSubmit={formik.handleSubmit}>
          <div className='primerosDatos'>
            {/*--------------------------NOMBRE DE LA PROPIEDAD -------------------*/}
            <label className='labelPN' htmlFor="nombreprop">Nombre de la Propiedad
              <div className='subProd'> <input className='inputPN'
                id="nombreprop"
                name="nombreprop"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.nombreprop}
                onBlur={formik.handleBlur}
                placeholder="Hotel Buenos Aires"
              /> {formik.errors.nombreprop ? <div className='errors'>{formik.errors.nombreprop}</div> : null}</div></label>

            {/*--------------------------CATEGORÍA -------------------*/}
            <label className='labelPN' htmlFor="categorias">Categoría
              <div className='subProd'>  {categorias == null ? null : (
                <div className='subProd'>
                  <select
                    name="categorias"

                    className='inputPN'
                    onChange={(e) => setCategoria(e.target.value)}>
                    {categorias.map((item) => (
                      <option key={item.id} value={item.id}> {item.title}</option>
                    ))}
                  </select>
                </div>
              )}</div></label>


            {/*--------------------------DIRECCIÓN -------------------*/}
            <label className='labelPN' htmlFor="direccion">Direccion
              <div className='subProd'> <input className='inputPN'
                id="direccion"
                name="direccion"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.direccion}
                onBlur={formik.handleBlur}
                placeholder="Av. San Martín 2110"
              />{formik.errors.direccion ? <div className='errors'>{formik.errors.direccion}</div> : null}</div></label>


            {/*--------------------------CIUDAD -------------------
            TODO poner valor por defecto ciudad..*/}
            <label className='labelPN' htmlFor="ciudad">Ciudad
              <div className='subProd'>  {ciudades == null ? null : (
                <div className='subProd'>
                  <select
                    name="ciudades"
                    className='inputPN'
                    onChange={(e) => setCiudad(e.target.value)}>
                    {ciudades.map((item) => (
                      <option key={item.id} value={item.id}> {item.name}, {item.country}</option>
                    ))}
                  </select>
                </div>
              )}</div></label>
            {/*--------------------------LATITUD -------------------*/}
            <label className='labelPN' htmlFor="latitud">Latitud
              <div className='subProd'> <input className='inputPN'
                id="latitud"
                name="latitud"
                type="bigint"
                onChange={formik.handleChange}
                value={formik.values.latitud}
                onBlur={formik.handleBlur}
                placeholder="-34.556"
              /> {formik.errors.latitud ? <div className='errors'>{formik.errors.latitud}</div> : null}</div></label>

            {/*-------------------------LONGITUD -------------------*/}
            <label className='labelPN' htmlFor="longitud">Longitud
              <div className='subProd'> <input className='inputPN'
                id="longitud"
                name="longitud"
                type="bigint"
                onChange={formik.handleChange}
                value={formik.values.longitud}
                onBlur={formik.handleBlur}
                placeholder="-50.596"
              />{formik.errors.longitud ? <div className='errors'>{formik.errors.longitud}</div> : null}</div></label>
          </div>

          {/*--------------------------DESCRIPCIÓN -------------------*/}
          <div className="descYatr">
          <label className='labelPN' htmlFor="descripcion">Descripción
            <div className='subProd'> <input className='inputTextarea'
              id="descripcionA"
              name="descripcionA"
              type="textarea"
              onChange={formik.handleChange}
              value={formik.values.descripcionA}
              onBlur={formik.handleBlur}
              placeholder="Escribir aquí sobre el alojamiento"
            />  {formik.errors.descripcionA ? <div className='errors'>{formik.errors.descripcionA}</div> : null}</div>

            <div className='subProd'> <input className='inputTextarea'
              id="descripcionB"
              name="descripcionB"
              type="textarea"
              onChange={formik.handleChange}
              value={formik.values.descripcionB}
              onBlur={formik.handleBlur}
              placeholder="Escribir aquí sobre las habitaciones"
            />  {formik.errors.descripcionB ? <div className='errors'>{formik.errors.descripcionB}</div> : null}</div>

            <div className='subProd'> <input className='inputTextarea'
              id="descripcionC"
              name="descripcionC"
              type="textarea"
              onChange={formik.handleChange}
              value={formik.values.descripcionC}
              onBlur={formik.handleBlur}
              placeholder="Escribir aquí sobre el desayuno"
            /> {formik.errors.descripcionC ? <div className='errors'>{formik.errors.descripcionC}</div> : null}</div>

            <div className='subProd'> <input className='inputTextarea'
              id="descripcionD"
              name="descripcionD"
              type="textarea"
              onChange={formik.handleChange}
              value={formik.values.descripcionD}
              onBlur={formik.handleBlur}
              placeholder="Escribir aquí sobre el barrio"
            />{formik.errors.descripcionD ? <div className='errors'>{formik.errors.descripcionD}</div> : null}</div></label>

          {/*--------------------------ATRIBUTOS -------------------*/}
          <h3 className="subtituloPN">Agregar atributos</h3>
          <div className="atributos-cointainer">

            <div><input className="checkboxPN" type="checkbox"
              id="1"
              name="estacionamiento"
              value="estacionamiento" ></input>
              <label className='labelPN' htmlFor="estacionamiento"> Estacionamiento </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="2"
              name="wifi"
              value="wifi" ></input>
              <label className='labelPN' htmlFor="accept"> Wifi Gratis </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="3"
              name="spa"
              value="spa" ></input>
              <label className='labelPN' htmlFor="spa"> Spa </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="4"
              name="restaurante"
              value="restaurante" ></input>
              <label className='labelPN' htmlFor="restaurante"> Restaurante </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="5"
              name="bar"
              value="bar" ></input>
              <label className='labelPN' htmlFor="bar"> Bar </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="6"
              name="pileta"
              value="pileta" ></input>
              <label className='labelPN' htmlFor="pileta"> Pileta </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="7"
              name="desayuno"
              value="desayuno" ></input>
              <label className='labelPN' htmlFor="desayuno"> Desayuno </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="8"
              name="ubicacion"
              value="ubicacion" ></input>
              <label className='labelPN' htmlFor="ubicacion"> Ubicación frente a la playa </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="9"
              name="televisor"
              value="televisor" ></input>
              <label className='labelPN' htmlFor="televisor"> Televisor </label></div>

            <div><input className="checkboxPN" type="checkbox"
              id="10"
              name="mascotas"
              value="mascotas" ></input>
              <label className='labelPN' htmlFor="mascotas"> Acepta mascotas </label></div>

          </div>
</div>
          {/*--------------------------Imágenes -------------------*/}
          <h3 className="subtituloPN">Agregar imágenes</h3>
          <ol>
            <li className="labelPN">
              <div className='imagenes'><label className='labelPN'>URL: <input className='inputPNimg'
                id="url1"
                name="url1"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.url1}
                onBlur={formik.handleBlur}
                placeholder="Coloque la URL de la imágen"
              /></label>

                <label className='labelPN'>Título  <input className='inputPNimg'
                  id="titulo1"
                  name="titulo1"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.titulo1}
                  onBlur={formik.handleBlur}
                  placeholder="Título de la imagen"
                /></label>

                <label className='labelPN'>Descripción  <input className='inputPNimgDesc'
                  id="descripcion1"
                  name="descripcion1"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.descripcion1}
                  onBlur={formik.handleBlur}
                  placeholder="Descripción de la imágen"
                /></label></div>
              {formik.errors.descripcion1 ? <div className='errors'>{formik.errors.descripcion1}</div> : null}
            </li>
            <li className="labelPN">
              <div className='imagenes'><label className='labelPN'>URL: <input className='inputPNimg'
                id="url2"
                name="url2"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.url2}
                onBlur={formik.handleBlur}
                placeholder="Coloque la URL de la imágen"
              /></label>

                <label className='labelPN'>Título  <input className='inputPNimg'
                  id="titulo2"
                  name="titulo2"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.titulo2}
                  onBlur={formik.handleBlur}
                  placeholder="Título de la imagen"
                /></label>

                <label className='labelPN'>Descripción  <input className='inputPNimgDesc'
                  id="descripcion2"
                  name="descripcion2"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.descripcion2}
                  onBlur={formik.handleBlur}
                  placeholder="Descripción de la imágen"
                /></label></div>
              {formik.errors.descripcion2 ? <div className='errors'>{formik.errors.descripcion2}</div> : null}
            </li>
            <li className="labelPN">
              <div className='imagenes'><label className='labelPN'>URL: <input className='inputPNimg'
                id="url3"
                name="url3"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.url3}
                onBlur={formik.handleBlur}
                placeholder="Coloque la URL de la imágen"
              /></label>

                <label className='labelPN'>Título  <input className='inputPNimg'
                  id="titulo3"
                  name="titulo3"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.titulo3}
                  onBlur={formik.handleBlur}
                  placeholder="Título de la imagen"
                /></label>

                <label className='labelPN'>Descripción  <input className='inputPNimgDesc'
                  id="descripcion3"
                  name="descripcion3"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.descripcion3}
                  onBlur={formik.handleBlur}
                  placeholder="Descripción de la imágen"
                /></label></div>
              {formik.errors.descripcion3 ? <div className='errors'>{formik.errors.descripcion3}</div> : null}
            </li>
            <li className="labelPN">
              <div className='imagenes'><label className='labelPN'>URL: <input className='inputPNimg'
                id="url4"
                name="url4"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.url4}
                onBlur={formik.handleBlur}
                placeholder="Coloque la URL de la imágen"
              /></label>

                <label className='labelPN'>Título  <input className='inputPNimg'
                  id="titulo4"
                  name="titulo4"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.titulo4}
                  onBlur={formik.handleBlur}
                  placeholder="Título de la imagen"
                /></label>

                <label className='labelPN'>Descripción  <input className='inputPNimgDesc'
                  id="descripcion4"
                  name="descripcion4"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.descripcion4}
                  onBlur={formik.handleBlur}
                  placeholder="Descripción de la imágen"
                /></label></div>
              {formik.errors.descripcion4 ? <div className='errors'>{formik.errors.descripcion4}</div> : null}
            </li>
            <li className="labelPN">
              <div className='imagenes'><label className='labelPN'>URL: <input className='inputPNimg'
                id="url5"
                name="url5"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.url5}
                onBlur={formik.handleBlur}
                placeholder="Coloque la URL de la imágen"
              /></label>

                <label className='labelPN'>Título  <input className='inputPNimg'
                  id="titulo5"
                  name="titulo5"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.titulo5}
                  onBlur={formik.handleBlur}
                  placeholder="Título de la imagen"
                /></label>

                <label className='labelPN'>Descripción  <input className='inputPNimgDesc'
                  id="descripcion5"
                  name="descripcion5"
                  type="text"
                  onChange={formik.handleChange}
                  value={formik.values.descripcion5}
                  onBlur={formik.handleBlur}
                  placeholder="Descripción de la imágen"
                /></label></div>
              {formik.errors.descripcion5 ? <div className='errors'>{formik.errors.descripcion5}</div> : null}
            </li>
          </ol>

          {/*--------------------------Políticas del producto -------------------*/}
          <h3 className="subtituloPN">Políticas del producto</h3>
          <div className="politicas-container">
            <div>
              <label className='labelPoliticas'>Normas de la casa:

                <div><input className="checkboxPN" type="checkbox"
                  id="1"
                  name="Check-out"
                  value="Check-out" ></input>
                  <label className='labelPN' htmlFor="Check-out"> Check-out: 10:00 a.m.  </label></div>

                <div><input className="checkboxPN" type="checkbox"
                  id="2"
                  name="ruido"
                  value="ruido" ></input>
                  <label className='labelPN' htmlFor="ruido"> No hacer ruido de 23:00-7:00 </label></div>

                <div><input className="checkboxPN" type="checkbox"
                  id="3"
                  name="mascotas"
                  value="mascotas" ></input>
                  <label className='labelPN' htmlFor="mascotas"> No se aceptan mascotas. </label></div>

                <div><input className="checkboxPN" type="checkbox"
                  id="4"
                  name="invitados"
                  value="invitados" ></input>
                  <label className='labelPN' htmlFor="invitados"> Prohibido invitados en habitaciones. </label></div>
              </label>
            </div>
            <div>
              <label className='labelPoliticas'>Salud y seguridad:
                <div><input className="checkboxPN" type="checkbox"
                  id="5"
                  name="Fumar"
                  value="Fumar" ></input>
                  <label className='labelPN' htmlFor="Fumar"> Prohibido Fumar. </label></div>

                <div><input className="checkboxPN" type="checkbox"
                  id="6"
                  name="distanciamiento"
                  value="distanciamiento" ></input>
                  <label className='labelPN' htmlFor="distanciamiento"> Normas de distanciamiento social. </label></div>
                <div><input className="checkboxPN" type="checkbox"
                  id="7"
                  name="Cajas"
                  value="Cajas" ></input>
                  <label className='labelPN' htmlFor="Cajas"> Cajas de seguridad a disposición. </label></div>

                <div><input className="checkboxPN" type="checkbox"
                  id="8"
                  name="emergencias"
                  value="emergencias" ></input>
                  <label className='labelPN' htmlFor="emergencias"> Servicio de emergencias. </label></div>
              </label></div>
            <div>
              <label className='labelPoliticas'>Políticas de cancelación:
                <div><input className="checkboxPN" type="checkbox"
                  id="9"
                  name="7dias"
                  value="7dias" ></input>
                  <label className='labelPN' htmlFor="7dias"> Reintegro con 7 días de anticipación. </label></div>

                <div><input className="checkboxPN" type="checkbox"
                  id="10"
                  name="15dias"
                  value="15dias" ></input>
                  <label className='labelPN' htmlFor="15dias"> Reintegro con 15 días de anticipación. </label></div>
                <div><input className="checkboxPN" type="checkbox"
                  id="11"
                  name="30dias"
                  value="30dias" ></input>
                  <label className='labelPN' htmlFor="30dias"> Reintegro con 30 días de anticipación. </label></div>

                <div><input className="checkboxPN" type="checkbox"
                  id="12"
                  name="noreintegrable"
                  value="pinoreintegrable" ></input>
                  <label className='labelPN' htmlFor="noreintegrable"> Reserva no reintegrable. </label></div>
              </label></div>

          </div>


          <button type="submit" className='btPN'>Crear</button>
        </form></div>
    </div>
  );
}

export default FormProducto;





