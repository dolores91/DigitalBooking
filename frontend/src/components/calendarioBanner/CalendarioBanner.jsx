import { React} from "react";
import DatePicker, { registerLocale, setDefaultLocale } from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import es from "date-fns/locale/es";
import '../calendario/calendario.css'


export default function CalendarioBanner({startDate, endDate, setDateRange}) {
    
   
  return (
   
        <div>
        <DatePicker
            placeholderText=" Check in - Check out"
            isInputWithCalendar={true}
            className="inputBanner"
            selectsRange={true}
            startDate={startDate}
            endDate={endDate}
            onChange={(update) => {
              setDateRange(update);
            }}
            minDate={new Date()}
            locale="es"
            monthsShown={2}
            dateFormat="yyyy/MM/d"
            changeMonth
        />
    </div>

   
  )
}
