import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
public class Course{
private Subject subject;
   
   @ManyToOne
   public Subject getSubject() {
      return this.subject;
   }
   
   public void setSubject(Subject subject) {
      this.subject = subject;
   }
   
private Set<Tutor> tutor;

@ManyToMany
public Set<Tutor> getTutor() {
   return this.tutor;
}

public void setTutor(Set<Tutor> tutors) {
   this.tutor = tutors;
}

   private Set<Session> session;
   
   @OneToMany(mappedBy="course" )
   public Set<Session> getSession() {
      return this.session;
   }
   
   public void setSession(Set<Session> sessions) {
      this.session = sessions;
   }

private String name;

public void setName(String value) {
    this.name = value;
}
public String getName() {
    return this.name;
}
}
