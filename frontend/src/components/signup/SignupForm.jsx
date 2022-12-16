import React, { useState, useContext, useEffect } from 'react';
import { useFormik } from 'formik';
import "./signup.css";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import axios from 'axios';
import { loginApi, registroApi } from '../signupLogin/SignupLogin';
import ContextUsuario from "../../context/UserContext";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faExclamationTriangle } from "@fortawesome/free-solid-svg-icons";

const validate = values => {
  const errors = {};
  if (!values.firstName) {
    errors.firstName = 'Debe ingresar un nombre';
  }

  if (!values.lastName) {
    errors.lastName = 'Debe ingresar un apellido';
  }

  if (!values.email) {
    errors.email = 'Debe ingresar un correo electrónico válido';
  } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
    errors.email = 'El email no es válido';
  }

  if (values.password.length < 6) {
    errors.password = 'La contraseña debe tener 6 dígitos o más';
  }

  if (values.password !== values.password2) {
    errors.password2 = 'Las contraseñas ingresadas no coinciden';
  }
  return errors;
  ;
}

const SignupForm = () => {
  const { existeUsuario } = useContext(ContextUsuario)
  const [formularioValido, cambiarFormularioValido] = useState(true);
  const navigate = useNavigate();  
  const [email, setEmail] = useState({ campo: "", valido: null});
  const [name, setName] = useState({ campo: "", valido: null});
  const [surname, setSurname] = useState({ campo: "", valido: null });
  const [password, setPassword] = useState({ campo: "", valido: null });
  const [password2, setPassword2] = useState({ campo: "", valido: null });

  const isFormValid = () => {
    return (
      name.valido &&
      surname.valido &&
      email.valido &&
      password.valido &&
      password2.valido === 'true'
    );
  };

  const formik = useFormik({
    initialValues: {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      password2: '',
    },
    validate,
    validateOnChange:false,
    validateOnBlur:false,
    onSubmit: async (values) => {
      console.log(values)
      //alert(JSON.stringify(values, null, 2));
      localStorage.setItem('values', JSON.stringify(values));
      alert("usuario registrado");
      navigate("/") //lo agregue yo pero anula el if..? (dolo)
      
      const newUser = {
        idNumber: "30111000",
        name: values.firstName,
        surname: values.lastName,
        email: values.email,
        password: values.password,
        role: {
          id: 1,
            name: "ROLE_ADMIN",
            active: "S"
        },
        
      };

      if ((isFormValid)) {
        const responseAPI = await registroApi(newUser)
        const responseToken = await loginApi(newUser)  
        console.log({responseAPI, responseToken})  
        existeUsuario({
          nombre: responseToken.name,
          apellido: responseToken.surname,
          mail: responseAPI.email,
          id: responseAPI.id,
          auth: true,
          redirect: false,
          rol: responseToken.role,
      });
          navigate("/");
      } else {
        cambiarFormularioValido(false);
      }
     // setEmail(values.email)
     // setName(values.firstName)
     // setSurname(values.lastName)
     // setPassword(values.password)
     // postUser()
      
     navigate("/")
    console.log(values.firstName, values.lastName);
    },
  });

  /*const postUser = () => {
    fetch('http://localhost:8087/api/v1/user', {
      method: 'PUT',
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ mail: 'values.email' , password: 'values.password', name: 'values.name', surname: 'values.surname' })
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
      });
  }
*/

  return (
    <div className='container-signup'>

      <Link to="/"><span className="material-symbols-outlined"> close</span></Link>
      <div className='flex-container'>

        <form onSubmit={formik.handleSubmit}>

          <div className='titulo'>Crear cuenta</div>
          <div className='sub-container'>

            <label className='labelSU' htmlFor="firstName"><div>Nombre </div>
              <div ><input className='inputSUNyA'
                id="firstName"
                name="firstName"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.firstName}
                onBlur={formik.handleBlur}
              /></div></label>
            {/*{formik.errors.firstName ? <div className='errors'>{formik.errors.firstName }</div> : null}*/}

            <label className='labelSU' htmlFor="lastName"><div>Apellido</div>
              <div><input className='inputSUNyA'
                id="lastName"
                name="lastName"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.lastName}
                onBlur={formik.handleBlur}
              /></div></label>
            {/*{formik.errors.lastName ? <div className='errors'>{formik.errors.lastName}</div> : null}*/}
            <div></div></div>
          <label className='labelSU' htmlFor="email">Correo electrónico</label>
          <div><input className='inputSU'
            id="email"
            name="email"
            type="email"
            onChange={formik.handleChange}
            value={formik.values.email}
            onBlur={formik.handleBlur}
          /></div>
          {formik.errors.email ? <div className='errors'>{formik.errors.email}</div> : null}
          <div>
            <label className='labelSU' htmlFor="password">Contraseña</label></div>
          <div><input className='inputSU'
            id="password"
            name="password"
            type="password"
            onChange={formik.handleChange}
            value={formik.values.password}
            onBlur={formik.handleBlur}
          /></div>
          {formik.errors.password ? <div className='errors'>{formik.errors.password}</div> : null}
          <div>
            <label className='labelSU' htmlFor="password2">Confirmar contraseña</label></div>
          <div><input className='inputSU'
            id="password2"
            name="password2"
            type="password"
            onChange={formik.handleChange}
            value={formik.values.password2}
            onBlur={formik.handleBlur}
          /></div>
          {formik.errors.password2 ? <div className='errors'>{formik.errors.password2}</div> : null}

          {formularioValido === 'false' && (
            <div className='mensajeError'>
              <p>
                <FontAwesomeIcon icon={faExclamationTriangle} />
                <b>Error:</b> Por favor rellena el formulario correctamente.
              </p>
            </div>
          )}

          <div>
            <button className='btSU'>Crear cuenta</button></div>


          <p className='textoSU'>¿Ya tienes una cuenta? <Link className='link' to="/LogIn">Iniciar sesión</Link></p>


        </form>
      </div></div>
  );
};
export default SignupForm;
