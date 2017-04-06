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
public class DisplayListForWSe implements Serializable{
       
    @XmlElement
    public String FavouriteUnit;
    @XmlElement
    public Integer Frenquency;

    
    
    public DisplayListForWSe(String favouriteUnit, Integer frenquency){
      
       this.FavouriteUnit = favouriteUnit;
       this.Frenquency = frenquency;
    }
    
    public DisplayListForWSe(){
    }
    
    @XmlTransient
    public String getFavouriteUnit() {
        return this.FavouriteUnit;
    }
    
    @XmlTransient
    public void setFavouriteUnit(String favouriteUnit) {
        this.FavouriteUnit = favouriteUnit;
    }
    
    @XmlTransient
    public Integer getFrenquency() {
        return this.Frenquency;
    }

    @XmlTransient
    public void setFrenquency(Integer frenquency) {
        this.Frenquency = frenquency;
    }
}
