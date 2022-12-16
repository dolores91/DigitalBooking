import axios from "axios";

export const registroApi = async (data) => {
    try {
        const response = await axios.post("http://localhost:8080/api/v1/user", data);
        if (response.status !== 201) {
            throw new Error("Lamentablemente no ha podido registrarse. Por favor intente más tarde")
        } else {
            console.log("respuesta1: ", response.data.data);
        }
        return response.data.data;
    } catch (error) {
        console.error("ERROR REGISTRO API ", error);
    }
};

export const loginApi = async ( data ) => { 
    try {
        const {username, password} = data 
        const credentials = {username, password}
        const response = await axios.post('http://localhost:8080/auth/token', credentials)
        if( response.status === 200 || response.status === 201 ){
            sessionStorage.clear()
            sessionStorage.setItem('token', JSON.stringify(response.data.jwt))
            sessionStorage.setItem('user', JSON.stringify({name:response.data.name, surname:response.data.surname}))
            console.log('anda', response.data);
        }else{
            throw new Error('error login: ')
        }
        return response.data
    }
    catch ( error ){ 
        console.error("error login catch: ", error);
    }
}