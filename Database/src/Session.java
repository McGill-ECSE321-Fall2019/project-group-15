import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.ManyToMany;

@Entity
public class Session{
   private String date;

public void setDate(String value) {
    this.date = value;
}
public String getDate() {
    return this.date;
}
<<<<<<< HEAD
   private Room room;
   
   @ManyToOne(optional=false)
   public Room getRoom() {
      return this.room;
   }
   
   public void setRoom(Room room) {
      this.room = room;
   }
   
   private Tutor tutor;
   
   @ManyToOne(optional=false)
   public Tutor getTutor() {
      return this.tutor;
   }
   
   public void setTutor(Tutor tutor) {
      this.tutor = tutor;
   }
   
   private Set<Student> student;
   
   @ManyToMany
   public Set<Student> getStudent() {
      return this.student;
   }
   
   public void setStudent(Set<Student> students) {
      this.student = students;
   }
   
   private Course course;
   
   @ManyToOne(optional=false)
   public Course getCourse() {
      return this.course;
   }
   
   public void setCourse(Course course) {
      this.course = course;
   }
   
   private Manager manager;
   
   @ManyToOne(optional=false)
   public Manager getManager() {
      return this.manager;
   }
   
   public void setManager(Manager manager) {
      this.manager = manager;
   }
   
   }
=======
private Room room;

@ManyToOne(optional=false)
public Room getRoom() {
   return this.room;
}

public void setRoom(Room room) {
   this.room = room;
}

private Tutor tutor;

@ManyToOne(optional=false)
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

private Set<Student> student;

@ManyToMany
public Set<Student> getStudent() {
   return this.student;
}

public void setStudent(Set<Student> students) {
   this.student = students;
}

private Course course;

@ManyToOne(optional=false)
public Course getCourse() {
   return this.course;
}

public void setCourse(Course course) {
   this.course = course;
}

private Manager manager;

@ManyToOne(optional=false)
public Manager getManager() {
   return this.manager;
}

public void setManager(Manager manager) {
   this.manager = manager;
}

private SessionType type;

public void setType(SessionType value) {
    this.type = value;
}
public SessionType getType() {
    return this.type;
}
}
>>>>>>> b17574b3506f3343c4ff5e0484a123048fb4944c
