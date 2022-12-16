import React, { useState } from 'react';
import "./reservaForm.css"
import { useFormik } from 'formik';

const validate = values => {
    const errors = {};
    if (!values.email) {
        errors.email = 'Debe ingresar un email';
    }
    if (!values.nombre) {
        errors.nombre = 'Debe ingresar un nombre';
    }
    if (!values.apellido) {
        errors.apellido = 'Debe ingresar un apellido';
    }
    if (!values.ciudad) {
        errors.ciudad = 'Debe ingresar la ciudad';
    }

    return errors;
    ;
}
const ReservaForm = () => {
    //const [email, setemail] = useState("Correo Electónico");
    //const [nombre, setnombre] = useState("Nombre");
    //const [apellido, setapellido] = useState("Apellido");
    const formik = useFormik({
        initialValues: {
            email: '',
            nombre: '',
            apellido: '',
            ciudad: '',

        },
        validate,
        validateOnChange: false,
        
        onSubmit: values => {
            alert("guardando cambios")
            // postUser()
            //  navigate("/creacionexitosa")

        },
    })
    return (

        <div>
            <h2 className='title-form'>Completá tus datos</h2>
            <div className="reserva-form">
                <label className='labelSU' htmlFor="nombre"><div>Nombre </div>
                    <div ><input className='inputRF'
                        id="nombre"
                        name="nombre"
                        type="text"
                        onChange={formik.handleChange}
                        value={formik.values.nombre}
                        onBlur={formik.handleBlur}
                        placeholder="Escriba aquí su nombre" />
                        {formik.errors.nombre ? <div className='errors'>{formik.errors.nombre}</div> : null}

                    </div></label>
                <label className='labelSU' htmlFor="apellido"><div>Apellido</div>
                    <div><input className='inputRF'
                      id="apellido"
                        name="apellido"
                        type="text"
                        onChange={formik.handleChange}
                        value={formik.values.apellido}
                        onBlur={formik.handleBlur}
                        placeholder="Escriba aquí su apellido" />
                        {formik.errors.apellido ? <div className='errors'>{formik.errors.apellido}</div> : null}
                    </div></label>
                <label className='labelSU' htmlFor="email"><div>Correo electrónico</div>
                    <div><input className='inputRF'
                        id="email"
                        name="email"
                        type="text"
                        onChange={formik.handleChange}
                        value={formik.values.email}
                        onBlur={formik.handleBlur}
                        placeholder="Escriba aquí su E-mail" />
                        {formik.errors.email ? <div className='errors'>{formik.errors.email}</div> : null}

                    </div></label>

                <label className='labelSU' htmlFor="ciudad"><div>Ciudad</div>
                    <div><input className='inputRF'
                         id="ciudad"
                        name="ciudad"
                        type="text"
                        onChange={formik.handleChange}
                        value={formik.values.ciudad}
                        onBlur={formik.handleBlur}
                        placeholder="Escriba aquí su ciudad" />
                        {formik.errors.ciudad ? <div className='errors'>{formik.errors.ciudad}</div> : null}
                    </div></label>

            </div>
           
        </div>

    );
}

export default ReservaForm;
