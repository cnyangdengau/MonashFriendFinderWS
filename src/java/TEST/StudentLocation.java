/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yang-Deng
 */
@Entity
@Table(name = "STUDENT_LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentLocation.findAll", query = "SELECT s FROM StudentLocation s")
    , @NamedQuery(name = "StudentLocation.findByLocationId", query = "SELECT s FROM StudentLocation s WHERE s.locationId = :locationId")
    , @NamedQuery(name = "StudentLocation.findByTimeStamp", query = "SELECT s FROM StudentLocation s WHERE s.timeStamp = :timeStamp")
    , @NamedQuery(name = "StudentLocation.findByLatitude", query = "SELECT s FROM StudentLocation s WHERE s.latitude = :latitude")
    , @NamedQuery(name = "StudentLocation.findByLongitude", query = "SELECT s FROM StudentLocation s WHERE s.longitude = :longitude")
    , @NamedQuery(name = "StudentLocation.findByLocationName", query = "SELECT s FROM StudentLocation s WHERE s.locationName = :locationName")
    , @NamedQuery(name = "StudentLocation.findByStudentNumber", query = "SELECT s FROM StudentLocation s WHERE s.studentNumber.studentNumber = :studentNumber")
})
public class StudentLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOCATION_ID")
    private Integer locationId;
    @Column(name = "TIME_STAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    @Size(max = 20)
    @Column(name = "LATITUDE")
    private String latitude;
    @Size(max = 20)
    @Column(name = "LONGITUDE")
    private String longitude;
    @Size(max = 40)
    @Column(name = "LOCATION_NAME")
    private String locationName;
    @JoinColumn(name = "STUDENT_NUMBER", referencedColumnName = "STUDENT_NUMBER")
    @ManyToOne
    private StudentProfile studentNumber;

    public StudentLocation() {
    }

    public StudentLocation(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public StudentProfile getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(StudentProfile studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentLocation)) {
            return false;
        }
        StudentLocation other = (StudentLocation) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TEST.StudentLocation[ locationId=" + locationId + " ]";
    }
    
}
