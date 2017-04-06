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
public class DisplayListForWSa implements Serializable {
    
    @XmlElement
    public String LocationName;
    @XmlElement
    public Integer Frenquence;

    public DisplayListForWSa(String location,Integer frequence){
      
       this.LocationName = location;
       this.Frenquence = frequence;
    }
    
    @XmlTransient
    public String getLocation() {
        return this.LocationName;
    }
    
    @XmlTransient
    public void setLocation(String location) {
        this.LocationName = location;
    }
    
    @XmlTransient
    public Integer getFrequency() {
        return this.Frenquence;
    }

    @XmlTransient
    public void setFrequency(Integer frequence) {
        this.Frenquence = frequence;
    }
        
    public DisplayListForWSa(){
    }
    
}
