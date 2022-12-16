import React, { useState } from "react"
import { createContext } from "react"
import { useNavigate } from "react-router-dom";



const ContextUsuario = createContext()
const baseDeDatos = {
    usuarios: [{
        "id": 1,
        "nombre": "Dolores",
        "apellido": "Aleman",
        "mail": "doloresalemang@gmail.com",
        "password": "123456",
        "isAdm": true
    },
    {
        "id": 2,
        "nombre": "Guillermina",
        "apellido": "Santia",
        "mail": "guillermina@gmail.com",
        "password": "123456",
        "isAdm": false
    },
    {
        "id": 3,
        "nombre": "Lucas",
        "apellido": "Garcia",
        "mail": "lucas@gmail.com",
        "password": "123456",
        "isAdm": false
    },
    {
        "id": 4,
        "nombre": "Silvia",
        "apellido": "Ratero",
        "mail": "Silvia@gmail.com",
        "password": "123456",
        "isAdm": true
    }
    ]
}

/*TODO eliminar cache de estaEnReserva*/
export const UserContext = ({ children }) => {

    const navigate = useNavigate();
    const [estaEnReserva, setestaEnReserva] = useState(false);
    const [userAuth, setuserAuth] = useState(false);
    const [isAdm, setIsAdm] = useState(false);
    const [nombre, setnombre] = useState("Dolores");
    const [iniciales, setiniciales] = useState("DA");
    const id = sessionStorage.getItem('idProducto');
    const url = '/Reserva/'
    const urlId = url.concat(id)
    // console.log(url);
    // console.log(urlId);

    //console.log(id);

    const existeUsuario = (mail, password) => {
        console.log(baseDeDatos.usuarios.find(usr => usr.mail === mail && usr.password === password))

        if (baseDeDatos.usuarios.find(usr => usr.mail === mail && usr.password === password)) {
            setuserAuth(true);
            console.log("ingreso correcto");
            sessionStorage.setItem('mail', JSON.stringify(mail));
            sessionStorage.setItem('password', JSON.stringify(password));

            if (estaEnReserva === true) {
                navigate(urlId)
            } else {
                navigate("/")
            }
        } else {
            //alert('Por favor vuelva a intentarlo, sus credenciales son inválidas')
            setuserAuth(false);
        }
    }



    const tipoDeUsuario = (mail) => {
        const resultado = baseDeDatos.usuarios.find(usuario => usuario.mail === mail);
        console.log(resultado.isAdm);
        //const nombre = resultado.nombre
        //const nombreI = nombre.charAt(0)
        // const apellido = resultado.apellido
        //const apellidoI = apellido.charAt(0)
        //const concatenadas = nombreI.concat(apellidoI)
        //sessionStorage.setItem('iniciales', JSON.stringify(concatenadas));
        //sessionStorage.setItem('nombre', JSON.stringify(nombre));
        if (resultado.isAdm === true) {
            setIsAdm(true)
        } else {
            setIsAdm(false)
        }
        //alert("estamos chequeando el tipo de usuario")
    }
    const nombreHeader = (mail) => {
        const resultado = baseDeDatos.usuarios.find(usuario => usuario.mail === mail);
        console.log(resultado.isAdm);
        const nombre = resultado.nombre
        const nombreI = nombre.charAt(0)
        const apellido = resultado.apellido
        const apellidoI = apellido.charAt(0)
        const concatenadas = nombreI.concat(apellidoI)
        if (nombre !== null) {
            setnombre(nombre)
            setiniciales(concatenadas)
        } else {
            setnombre("Dolores")
            setiniciales("DA")
        }
        //alert("estamos chequeando el tipo de usuario")
    }
    /*   const iniciales = (mail) => {
           const resultado = baseDeDatos.usuarios.find(usuario => usuario.mail === mail);
           console.log(resultado.nombre)
           console.log(resultado.apellido)
        
           alert("estamos chequeando iniciales")
           //en header mandar el context al principio y en la funcion 
           //import ContextUsuario from "../../context/UserContext";
           //cortar las palabras y guardarlas en valiables concatenadas
       }*/





    const handleClickProd = (event) => {

        event.preventDefault();
        if (userAuth) {
            navigate(urlId)
        } else {
            navigate("/LogIn")
            console.log("viene desde reserva?");
            setestaEnReserva(true)
        }
    }


    return (
        <ContextUsuario.Provider value={{ setuserAuth, userAuth, existeUsuario, estaEnReserva, setestaEnReserva, handleClickProd, isAdm, urlId, tipoDeUsuario, nombreHeader, nombre, iniciales }}>
            {children}
        </ContextUsuario.Provider>
    )
}

export default ContextUsuario;




