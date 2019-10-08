import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Person{
   private Set<PersonRole> personRole;
   
   @OneToMany(mappedBy="person" )
   public Set<PersonRole> getPersonRole() {
      return this.personRole;
   }
   
   public void setPersonRole(Set<PersonRole> personRoles) {
      this.personRole = personRoles;
   }
   
   private String firstName;

public void setFirstName(String value) {
    this.firstName = value;
}
public String getFirstName() {
    return this.firstName;
}
private String lastName;

public void setLastName(String value) {
    this.lastName = value;
}
public String getLastName() {
    return this.lastName;
}
}
