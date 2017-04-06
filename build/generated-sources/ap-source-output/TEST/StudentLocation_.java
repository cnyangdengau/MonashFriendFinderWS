package TEST;

import TEST.StudentProfile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T23:02:28")
@StaticMetamodel(StudentLocation.class)
public class StudentLocation_ { 

    public static volatile SingularAttribute<StudentLocation, Date> timeStamp;
    public static volatile SingularAttribute<StudentLocation, String> locationName;
    public static volatile SingularAttribute<StudentLocation, Integer> locationId;
    public static volatile SingularAttribute<StudentLocation, StudentProfile> studentNumber;
    public static volatile SingularAttribute<StudentLocation, String> latitude;
    public static volatile SingularAttribute<StudentLocation, String> longitude;

}