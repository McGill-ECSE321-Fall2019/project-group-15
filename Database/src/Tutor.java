import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

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

private Set<Evaluation> evaluation;

@OneToMany(mappedBy="tutor" )
public Set<Evaluation> getEvaluation() {
   return this.evaluation;
}

public void setEvaluation(Set<Evaluation> evaluations) {
   this.evaluation = evaluations;
}

private int tutorID;

public void setTutorID(int value) {
    this.tutorID = value;
}
public int getTutorID() {
    return this.tutorID;
}
}
