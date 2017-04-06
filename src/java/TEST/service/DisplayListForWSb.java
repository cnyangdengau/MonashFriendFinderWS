/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST.service;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author Yang-Deng
 */

@XmlRootElement
public class DisplayListForWSb implements Serializable {
    
    @XmlElement
    public String FirstName;
    @XmlElement
    public String LastName;
    @XmlElement
    public Double Latitude;
    @XmlElement
    public Double Longitude;
    @XmlElement
    public Double Distance;
    
    
    public DisplayListForWSb(String firstname, String lastname, Double latitude, Double longitude, Double distance){
      
       this.FirstName = firstname;
       this.LastName = lastname;
       this.Latitude = latitude;
       this.Longitude = longitude;
       this.Distance = distance;
    }
    
    public DisplayListForWSb(){
    }
    
    @XmlTransient
    public String getFirstName() {
        return this.FirstName;
    }
    
    @XmlTransient
    public void setFirstName(String firstname) {
        this.FirstName = firstname;
    }
    
    @XmlTransient
    public String getLastName() {
        return this.LastName;
    }

    @XmlTransient
    public void setLastName(String lastname) {
        this.LastName = lastname;
    }
    
    @XmlTransient
    public Double getLatitude() {
        return this.Latitude;
    }
    
    @XmlTransient
    public void setLatitude(Double latitude) {
        this.Latitude = latitude;
    }
    
    @XmlTransient
    public Double getLongitude() {
        return this.Longitude;
    }
    
    @XmlTransient
    public void setLongitude(Double longitude) {
        this.Longitude = longitude;
    }
    
    @XmlTransient
    public Double getDistance() {
        return this.Distance;
    }
    
    @XmlTransient
    public void setDistance(Double distance) {
        this.Distance = distance;
    }
}
