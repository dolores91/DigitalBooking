import React from 'react'
import { useState } from 'react';
import DatePicker from "react-datepicker";

import es from "date-fns/locale/es";
import "react-datepicker/dist/react-datepicker.css";
import './calendario.css'
const Calendario = () => {


  const [dateRange, setDateRange] = useState([null, null]);
  const [startDate, endDate] = dateRange;



  return (
<div className='calendario-producto'>
        <DatePicker

          calendarClassName="bordeCalendario"
          selectsRange={true}
          startDate={startDate}
          endDate={endDate}
          minDate={new Date()}
          onChange={(update) => {
            setDateRange(update);
          }}
          monthsShown={2}
          inline
        /></div>


     
    

  )
}

export default Calendario