import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Person{
   private Set<PersonRole> userRole;
   
   @OneToMany(mappedBy="user" )
   public Set<PersonRole> getUserRole() {
      return this.userRole;
   }
   
   public void setUserRole(Set<PersonRole> userRoles) {
      this.userRole = userRoles;
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
