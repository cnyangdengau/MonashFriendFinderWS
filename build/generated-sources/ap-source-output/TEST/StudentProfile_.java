package TEST;

import TEST.Friendship;
import TEST.StudentLocation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-07T12:04:21")
@StaticMetamodel(StudentProfile.class)
public class StudentProfile_ { 

    public static volatile SingularAttribute<StudentProfile, String> lastName;
    public static volatile SingularAttribute<StudentProfile, String> address;
    public static volatile SingularAttribute<StudentProfile, Date> subsciptionTime;
    public static volatile SingularAttribute<StudentProfile, String> gender;
    public static volatile SingularAttribute<StudentProfile, Integer> studentNumber;
    public static volatile SingularAttribute<StudentProfile, String> subsciptionData;
    public static volatile SingularAttribute<StudentProfile, String> monashEmail;
    public static volatile SingularAttribute<StudentProfile, String> favouriteUnitCode;
    public static volatile SingularAttribute<StudentProfile, String> nativeLanguage;
    public static volatile SingularAttribute<StudentProfile, String> favouriteSport;
    public static volatile CollectionAttribute<StudentProfile, Friendship> friendshipCollection1;
    public static volatile SingularAttribute<StudentProfile, String> firstName;
    public static volatile SingularAttribute<StudentProfile, String> password;
    public static volatile SingularAttribute<StudentProfile, String> currentJob;
    public static volatile SingularAttribute<StudentProfile, String> nationality;
    public static volatile SingularAttribute<StudentProfile, String> favouriteMovie;
    public static volatile SingularAttribute<StudentProfile, Date> dob;
    public static volatile CollectionAttribute<StudentProfile, StudentLocation> studentLocationCollection;
    public static volatile SingularAttribute<StudentProfile, String> suburb;
    public static volatile SingularAttribute<StudentProfile, String> course;
    public static volatile SingularAttribute<StudentProfile, String> studyMode;
    public static volatile CollectionAttribute<StudentProfile, Friendship> friendshipCollection;

}