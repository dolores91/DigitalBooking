import React from "react";
import './footer.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFacebook, faLinkedin, faTwitter, faInstagram } from "@fortawesome/free-brands-svg-icons";

const Footer = () => {
    return (
        
            <div className="footer">
            <div><p>©2022 Digital Booking</p></div>
            
            <div className="iconos">
                <a href="/">
                    <FontAwesomeIcon icon={faFacebook} className= "redes"/>
                </a> 
                <a href="/">
                    <FontAwesomeIcon icon={faLinkedin} className= "redes" />
                </a>
                <a href="/">
                    <FontAwesomeIcon icon={faTwitter} className= "redes"/>
                </a>
                <a href="/">
                    <FontAwesomeIcon icon={faInstagram} className= "redes"/>
                </a>
                </div>
            </div>
       
    )
}

export default Footer;
