package TEST;

import TEST.StudentProfile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-30T23:02:28")
@StaticMetamodel(Friendship.class)
public class Friendship_ { 

    public static volatile SingularAttribute<Friendship, Date> friendshipEndDate;
    public static volatile SingularAttribute<Friendship, Integer> friendshipId;
    public static volatile SingularAttribute<Friendship, Date> friendshipStartDate;
    public static volatile SingularAttribute<Friendship, StudentProfile> studentNumber2;
    public static volatile SingularAttribute<Friendship, StudentProfile> studentNumber1;

}