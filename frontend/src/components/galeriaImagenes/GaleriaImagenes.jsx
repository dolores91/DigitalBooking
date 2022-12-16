import React from 'react'
import './galeriaImagenes.css'
import galeria from './galeriaImg.json'




const GaleriaImagenes = ({id}) => {

 
  return (

    <div className="gallery-grid">
    <div className="item-a">
        <img src={galeria[id].url[0]} alt="" /*onClick={() => showGallery(0)}*//>
    </div>
    {galeria[id].url.slice(1).map((img, index) => <img src={img} key={index} alt="img" /*onClick={() => showGallery(index + 1)}*/ />)}
</div>

    )}

    
export default GaleriaImagenes