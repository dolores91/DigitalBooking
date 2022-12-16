import React from "react";
import "./horario.css"



const HorarioLlegda = () => {
    return (
        <div>
            <h1 className="title-horario">
                Indicá tu horario estimado de llegada
            </h1> 
            <div className="cuadro-horario">
            <h4 className="subtitle-horario">
                Tu habitación va a estar lista para el check-in
                entre las 10:00 AM y las 11:00 PM.
            </h4>
            <h4 className="p-horario">Indicá tu horario estimado de llegada</h4>
           
            <select className="select-horario">
                <option className="optionHorario" selected value="default">Seleccionar una hora de llegada</option>
                <option value="01:00:00" className="optionHorario">01:00 AM </option>
                <option value="02:00:00" className="optionHorario">02:00 AM </option>
                <option value="03:00:00" className="optionHorario">03:00 AM </option>
                <option value="04:00:00" className="optionHorario">04:00 AM </option>
                <option value="05:00:00" className="optionHorario">05:00 AM </option>
                <option value="06:00:00" className="optionHorario">06:00 AM </option>
                <option value="07:00:00" className="optionHorario">07:00 AM </option>
                <option value="08:00:00" className="optionHorario">08:00 AM </option>
                <option value="09:00:00" className="optionHorario">09:00 AM </option>
                <option value="10:00:00" className="optionHorario">10:00 AM </option>
                <option value="11:00:00" className="optionHorario">11:00 AM </option>
                <option value="12:00:00" className="optionHorario">12:00 PM </option>
                <option value="13:00:00" className="optionHorario">01:00 PM </option>
                <option value="14:00:00" className="optionHorario">02:00 PM </option>
                <option value="15:00:00" className="optionHorario">03:00 PM </option>
                <option value="16:00:00" className="optionHorario">04:00 PM </option>
                <option value="17:00:00" className="optionHorario">05:00 PM </option>
                <option value="18:00:00" className="optionHorario">06:00 PM </option>
                <option value="19:00:00" className="optionHorario">07:00 PM </option>
                <option value="20:00:00" className="optionHorario">08:00 PM </option>
                <option value="21:00:00" className="optionHorario">09:00 PM </option>
                <option value="22:00:00" className="optionHorario">10:00 PM </option>
                <option value="23:00:00" className="optionHorario">11:00 PM </option>
                <option value="24:00:00" className="optionHorario">12:00 AM </option>
            </select>
        </div></div>

    );
}

export default HorarioLlegda;
