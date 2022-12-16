import React from "react";
import Calendario from "../../components/calendario/Calendario.jsx";
import HorarioLlegada from "../../components/horario/HorarioLlegda.jsx";
import "./reserva.css";
import "../../components/calendario/calendario.css";
import ReservaForm from "../../components/reservaForm/ReservaForm.jsx";
import DetalleReserva from "../../components/detalleReserva/DetalleReserva.jsx";
import { useParams } from "react-router-dom";
import Politicas from "../../components/politicas/Politicas.jsx";

export default function Reserva() {
  const { id } = useParams();
  return (
    <>
      <div className="tablasDeInformacion">
        <div className="completarDatos">
          <ReservaForm></ReservaForm>

          <div>
            <h2 className="title-fecha">Seleccioná tu fecha de reserva</h2>
            <div className="calendar-cuadro">
            <Calendario /></div>
          </div>
          <HorarioLlegada />
        </div>
        <div className="detalle-reserva-page">
          <DetalleReserva id={id} />
        </div>
      </div>
      <Politicas />
    </>
  );
}
