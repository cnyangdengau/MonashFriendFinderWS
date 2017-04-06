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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yang-Deng
 */
@Entity
@Table(name = "FRIENDSHIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendship.findAll", query = "SELECT f FROM Friendship f")
    , @NamedQuery(name = "Friendship.findByFriendshipId", query = "SELECT f FROM Friendship f WHERE f.friendshipId = :friendshipId")
    , @NamedQuery(name = "Friendship.findByFriendshipStartDate", query = "SELECT f FROM Friendship f WHERE f.friendshipStartDate = :friendshipStartDate")
    , @NamedQuery(name = "Friendship.findByFriendshipEndDate", query = "SELECT f FROM Friendship f WHERE f.friendshipEndDate = :friendshipEndDate")
    , @NamedQuery(name = "Friendship.findByStudentNumber1", query = "SELECT s FROM Friendship s WHERE s.studentNumber1.studentNumber = :studentNumber1")
    , @NamedQuery(name = "Friendship.findByStudentNumber2", query = "SELECT s FROM Friendship s WHERE s.studentNumber2.studentNumber = :studentNumber2")})
public class Friendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FRIENDSHIP_ID")
    private Integer friendshipId;
    @Column(name = "FRIENDSHIP_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date friendshipStartDate;
    @Column(name = "FRIENDSHIP_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date friendshipEndDate;
    @JoinColumn(name = "STUDENT_NUMBER2", referencedColumnName = "STUDENT_NUMBER")
    @ManyToOne
    private StudentProfile studentNumber2;
    @JoinColumn(name = "STUDENT_NUMBER1", referencedColumnName = "STUDENT_NUMBER")
    @ManyToOne
    private StudentProfile studentNumber1;

    public Friendship() {
    }

    public Friendship(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Date getFriendshipStartDate() {
        return friendshipStartDate;
    }

    public void setFriendshipStartDate(Date friendshipStartDate) {
        this.friendshipStartDate = friendshipStartDate;
    }

    public Date getFriendshipEndDate() {
        return friendshipEndDate;
    }

    public void setFriendshipEndDate(Date friendshipEndDate) {
        this.friendshipEndDate = friendshipEndDate;
    }

    public StudentProfile getStudentNumber2() {
        return studentNumber2;
    }

    public void setStudentNumber2(StudentProfile studentNumber2) {
        this.studentNumber2 = studentNumber2;
    }

    public StudentProfile getStudentNumber1() {
        return studentNumber1;
    }

    public void setStudentNumber1(StudentProfile studentNumber1) {
        this.studentNumber1 = studentNumber1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendshipId != null ? friendshipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendship)) {
            return false;
        }
        Friendship other = (Friendship) object;
        if ((this.friendshipId == null && other.friendshipId != null) || (this.friendshipId != null && !this.friendshipId.equals(other.friendshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TEST.Friendship[ friendshipId=" + friendshipId + " ]";
    }
    
}
