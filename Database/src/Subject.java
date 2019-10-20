import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Subject{
   private String name;
   
   public void setName(String value) {
      this.name = value;
   }
   
   public String getName() {
      return this.name;
   }
   
   private School school;
   
   @ManyToOne
   public School getSchool() {
      return this.school;
   }
   
   public void setSchool(School school) {
      this.school = school;
   }
   
   private Set<Course> course;
   
   @OneToMany(mappedBy="subject" )
   public Set<Course> getCourse() {
      return this.course;
   }
   
   public void setCourse(Set<Course> courses) {
      this.course = courses;
   }
   
   }
