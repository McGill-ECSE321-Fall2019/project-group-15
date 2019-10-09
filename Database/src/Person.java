import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Person{
<<<<<<< HEAD
   private Set<PersonRole> userRole;
   
   @OneToMany(mappedBy="user" )
   public Set<PersonRole> getUserRole() {
      return this.userRole;
   }
   
   public void setUserRole(Set<PersonRole> userRoles) {
      this.userRole = userRoles;
=======
   private Set<PersonRole> personRole;
   
   @OneToMany(mappedBy="person" )
   protected Set<PersonRole> getPersonRole() {
      return this.personRole;
   }
   
   protected void setPersonRole(Set<PersonRole> personRoles) {
      this.personRole = personRoles;
>>>>>>> b17574b3506f3343c4ff5e0484a123048fb4944c
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
