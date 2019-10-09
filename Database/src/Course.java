import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Course{
   private Set<Session> session;
   
   @OneToMany(mappedBy="course" )
   public Set<Session> getSession() {
      return this.session;
   }
   
   public void setSession(Set<Session> sessions) {
      this.session = sessions;
   }
   
   private String courseID;

public void setCourseID(String value) {
    this.courseID = value;
}
public String getCourseID() {
    return this.courseID;
}
}
