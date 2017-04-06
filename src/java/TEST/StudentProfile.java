/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yang-Deng
 */
@Entity
@Table(name = "STUDENT_PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentProfile.findAll", query = "SELECT s FROM StudentProfile s")
    , @NamedQuery(name = "StudentProfile.findByStudentNumber", query = "SELECT s FROM StudentProfile s WHERE s.studentNumber = :studentNumber")
    , @NamedQuery(name = "StudentProfile.findByFirstName", query = "SELECT s FROM StudentProfile s WHERE UPPER(s.firstName) = UPPER(:firstName)")
    , @NamedQuery(name = "StudentProfile.findByLastName", query = "SELECT s FROM StudentProfile s WHERE UPPER(s.lastName) = UPPER(:lastName)")
    , @NamedQuery(name = "StudentProfile.findByDob", query = "SELECT s FROM StudentProfile s WHERE s.dob = :dob")
    , @NamedQuery(name = "StudentProfile.findByGender", query = "SELECT s FROM StudentProfile s WHERE UPPER(s.gender) = UPPER(:gender)")
    , @NamedQuery(name = "StudentProfile.findByAddress", query = "SELECT s FROM StudentProfile s WHERE UPPER(s.address) = UPPER(:address)")
    , @NamedQuery(name = "StudentProfile.findBySuburb", query = "SELECT s FROM StudentProfile s WHERE s.suburb = :suburb")
    , @NamedQuery(name = "StudentProfile.findByNationality", query = "SELECT s FROM StudentProfile s WHERE s.nationality = :nationality")
    , @NamedQuery(name = "StudentProfile.findByNativeLanguage", query = "SELECT s FROM StudentProfile s WHERE s.nativeLanguage = :nativeLanguage")
    , @NamedQuery(name = "StudentProfile.findByFavouriteSport", query = "SELECT s FROM StudentProfile s WHERE s.favouriteSport = :favouriteSport")
    , @NamedQuery(name = "StudentProfile.findByFavouriteMovie", query = "SELECT s FROM StudentProfile s WHERE s.favouriteMovie = :favouriteMovie")
    , @NamedQuery(name = "StudentProfile.findByCurrentJob", query = "SELECT s FROM StudentProfile s WHERE s.currentJob = :currentJob")
    , @NamedQuery(name = "StudentProfile.findByMonashEmail", query = "SELECT s FROM StudentProfile s WHERE s.monashEmail = :monashEmail")
    , @NamedQuery(name = "StudentProfile.findByPassword", query = "SELECT s FROM StudentProfile s WHERE s.password = :password")
    , @NamedQuery(name = "StudentProfile.findByCourse", query = "SELECT s FROM StudentProfile s WHERE s.course = :course")
    , @NamedQuery(name = "StudentProfile.findByStudyMode", query = "SELECT s FROM StudentProfile s WHERE s.studyMode = :studyMode")
    , @NamedQuery(name = "StudentProfile.findByFavouriteUnitCode", query = "SELECT s FROM StudentProfile s WHERE s.favouriteUnitCode = :favouriteUnitCode")
    , @NamedQuery(name = "StudentProfile.findBySubsciptionData", query = "SELECT s FROM StudentProfile s WHERE s.subsciptionData = :subsciptionData")
    , @NamedQuery(name = "StudentProfile.findBySubsciptionTime", query = "SELECT s FROM StudentProfile s WHERE s.subsciptionTime = :subsciptionTime")
    , @NamedQuery(name = "StudentProfile.findByFullNameJoin", query = "SELECT S FROM StudentProfile S JOIN Friendship F ON F.studentNumber1.studentNumber = S.studentNumber WHERE F.studentNumber2.firstName =:firstname AND F.studentNumber2.lastName =:lastname")
})

public class StudentProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENT_NUMBER")
    private Integer studentNumber;
    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 10)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 20)
    @Column(name = "SUBURB")
    private String suburb;
    @Size(max = 20)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Size(max = 20)
    @Column(name = "NATIVE_LANGUAGE")
    private String nativeLanguage;
    @Size(max = 20)
    @Column(name = "FAVOURITE_SPORT")
    private String favouriteSport;
    @Size(max = 20)
    @Column(name = "FAVOURITE_MOVIE")
    private String favouriteMovie;
    @Size(max = 20)
    @Column(name = "CURRENT_JOB")
    private String currentJob;
    @Size(max = 40)
    @Column(name = "MONASH_EMAIL")
    private String monashEmail;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 10)
    @Column(name = "COURSE")
    private String course;
    @Size(max = 10)
    @Column(name = "STUDY_MODE")
    private String studyMode;
    @Size(max = 10)
    @Column(name = "FAVOURITE_UNIT_CODE")
    private String favouriteUnitCode;
    @Size(max = 50)
    @Column(name = "SUBSCIPTION_DATA")
    private String subsciptionData;
    @Column(name = "SUBSCIPTION_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subsciptionTime;
    @OneToMany(mappedBy = "studentNumber")
    private Collection<StudentLocation> studentLocationCollection;
    @OneToMany(mappedBy = "studentNumber2")
    private Collection<Friendship> friendshipCollection;
    @OneToMany(mappedBy = "studentNumber1")
    private Collection<Friendship> friendshipCollection1;
            
    public StudentProfile() {
    }

    public StudentProfile(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getFavouriteSport() {
        return favouriteSport;
    }

    public void setFavouriteSport(String favouriteSport) {
        this.favouriteSport = favouriteSport;
    }

    public String getFavouriteMovie() {
        return favouriteMovie;
    }

    public void setFavouriteMovie(String favouriteMovie) {
        this.favouriteMovie = favouriteMovie;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getMonashEmail() {
        return monashEmail;
    }

    public void setMonashEmail(String monashEmail) {
        this.monashEmail = monashEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(String studyMode) {
        this.studyMode = studyMode;
    }

    public String getFavouriteUnitCode() {
        return favouriteUnitCode;
    }

    public void setFavouriteUnitCode(String favouriteUnitCode) {
        this.favouriteUnitCode = favouriteUnitCode;
    }

    public String getSubsciptionData() {
        return subsciptionData;
    }

    public void setSubsciptionData(String subsciptionData) {
        this.subsciptionData = subsciptionData;
    }

    public Date getSubsciptionTime() {
        return subsciptionTime;
    }

    public String getAttributesByName(String A){
         switch (A) {                          
            case "favouriteUnitCode":{
                return this.getFavouriteUnitCode();
           }
            case "favouriteMovie":{
                return this.getFavouriteMovie();
           }
            case "favouriteSport":{
                return this.getFavouriteSport();
           }
            case "gender":{
                return this.getGender();
           }
            case "nativeLanguage":{
                return this.getNativeLanguage();
           }
            case "course":{
                return this.getCourse();
           }
            case "currentJob":{
                return this.getCurrentJob();
           }     
            case "studyMode":{
                return this.getStudyMode();
           }
            default :
                return null;
        }
    }
         
    public void setSubsciptionTime(Date subsciptionTime) {
        this.subsciptionTime = subsciptionTime;
    }

    @XmlTransient
    public Collection<StudentLocation> getStudentLocationCollection() {
        return studentLocationCollection;
    }

    public void setStudentLocationCollection(Collection<StudentLocation> studentLocationCollection) {
        this.studentLocationCollection = studentLocationCollection;
    }

    @XmlTransient
    public Collection<Friendship> getFriendshipCollection() {
        return friendshipCollection;
    }

    public void setFriendshipCollection(Collection<Friendship> friendshipCollection) {
        this.friendshipCollection = friendshipCollection;
    }

    @XmlTransient
    public Collection<Friendship> getFriendshipCollection1() {
        return friendshipCollection1;
    }

    public void setFriendshipCollection1(Collection<Friendship> friendshipCollection1) {
        this.friendshipCollection1 = friendshipCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentNumber != null ? studentNumber.hashCode() : 0);
        return hash;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentProfile)) {
            return false;
        }
        StudentProfile other = (StudentProfile) object;
        if ((this.studentNumber == null && other.studentNumber != null) || (this.studentNumber != null && !this.studentNumber.equals(other.studentNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TEST.StudentProfile[ studentNumber=" + studentNumber + " ]";
    }
    
}
