package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class Subject{
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
   
private String name;

public void setName(String value) {
this.name = value;
}
public String getName() {
return this.name;
}

private String description;

public void setDescription(String value) {
	this.description=value;
}
public String getDescription() {
    return this.description;
}
   
   }
