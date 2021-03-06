
package net.webservicex.es.correos.oficinasbuzones;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusquedaPorCodigoPostalResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "busquedaPorCodigoPostalResult"
})
@XmlRootElement(name = "BusquedaPorCodigoPostalResponse")
public class BusquedaPorCodigoPostalResponse {

    @XmlElement(name = "BusquedaPorCodigoPostalResult")
    protected String busquedaPorCodigoPostalResult;

    /**
     * Obtiene el valor de la propiedad busquedaPorCodigoPostalResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusquedaPorCodigoPostalResult() {
        return busquedaPorCodigoPostalResult;
    }

    /**
     * Define el valor de la propiedad busquedaPorCodigoPostalResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusquedaPorCodigoPostalResult(String value) {
        this.busquedaPorCodigoPostalResult = value;
    }

}
