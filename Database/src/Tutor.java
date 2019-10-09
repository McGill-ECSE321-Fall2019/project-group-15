import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Tutor extends PersonRole{
   private float hourlyRate;

public void setHourlyRate(float value) {
    this.hourlyRate = value;
}
public float getHourlyRate() {
    return this.hourlyRate;
}
private Set<Session> session;

@OneToMany(mappedBy="tutor" )
public Set<Session> getSession() {
   return this.session;
}

public void setSession(Set<Session> sessions) {
   this.session = sessions;
}

private int tutorID;

public void setTutorID(int value) {
    this.tutorID = value;
}
public int getTutorID() {
    return this.tutorID;
}
private Set<Evaluation> evaluation;

@ManyToMany
public Set<Evaluation> getEvaluation() {
   return this.evaluation;
}

public void setEvaluation(Set<Evaluation> evaluations) {
   this.evaluation = evaluations;
}

private boolean isVerified;

public void setIsVerified(boolean value) {
    this.isVerified = value;
}
public boolean isIsVerified() {
    return this.isVerified;
}
   private Set<Course> course;
   
   @ManyToMany
   public Set<Course> getCourse() {
      return this.course;
   }
   
   public void setCourse(Set<Course> courses) {
      this.course = courses;
   }
   
   }
