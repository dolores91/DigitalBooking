import React from "react";
import { Banner } from "../../components/banner/Banner";
import { Categoria } from "../../components/categoria/Categoria";
import { Listado } from "../../components/listado/Listado";
import { useEffect, useState } from "react";
import axios from "axios";
import { format } from "date-fns";


export const Home = () => {
  const [search, setSearch] = useState(0);
  const {filter, setFilter } = useState()
  const [filterCategoria, setFilterCategoria] = useState();
  const [dateRange, setDateRange] = useState([null, null]);
  const [startDate, endDate] = dateRange;
  
  const getFilter = async (data) => {
    //const token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaWx2aWFAZ21haWwuY29tIiwic3VybmFtZSI6IlJhdGVybyIsIm5hbWUiOiJTaWx2aWEiLCJpYXQiOjE2NzA1MzAzNTgsImV4cCI6MTY3MDUzMzk1OH0.kqwnmaQbKQIIATVcIspIJaA4Usxt1zeKKssCVpCfEu38YqPQBZrJaDwjc4I5wPhxIu26OEFf_97c5zz_YrDH1A"
    const config = {
      method: "POST",
      headers: {
        /* Authorization: `Bearer ${token}`, */ "content-type":
          "application/json",
      },
    };
    const response = await axios.post(
      "http://localhost:8080/api/v1/search_filter/city_dates",
      data,
      config
    );
    console.log({response});
    const jsonData = await response.data.response;
    console.log("jsonData: " , jsonData);
    setListado(jsonData);
  };
    
  const handleClick = () => {
    const data = {
      city: {
        id: search,
      },
      checkInDate: format(startDate, "yyyy-MM-dd"),
      checkOutDate: format(endDate, "yyyy-MM-dd"),
    };
    console.log("dataa: " + JSON.stringify(data));

    getFilter(JSON.stringify(data));

    setFilter(search);
  };


  const onDoubleClick = (searchCategoria, e) => {
    setFilterCategoria(searchCategoria);
   
  };


  useEffect(()=> {
   // console.log("categoria: ", filterCategoria);
  } ,[filterCategoria])

  const onClick = () => {
    setFilterCategoria(null);
    setFilter(null);
    setDateRange([null, null]);
  };


  const [listado, setListado] = useState(null);
 


  useEffect(() => {
    (async function () {
      const response = await axios.get("http://localhost:8080/api/v1/product");
      const jsonData = await response.data.response;
      setListado(jsonData);
    })();
   
  }, []);

    

  return (
    <div>
      {listado == null ? null : (
        <div>
          <Banner startDate={startDate}
          endDate={endDate}
          setDateRange={setDateRange}
          onChange={setSearch}
          onClick={handleClick}
        

          />
          <Categoria
         idCategoria={filterCategoria}
            setIdCategoria={setFilterCategoria}
            onDoubleClick={onDoubleClick} />
          <Listado 
            listado={listado}
            selectCiudad={search}
            selectCategoria={filterCategoria}
            startDate={startDate}
            endDate={endDate}
           

             />
        </div>
      )}
    </div>);


};

