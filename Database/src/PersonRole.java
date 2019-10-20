import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public abstract class PersonRole{
   private Person person;
   
   @ManyToOne(optional=false)
   public Person getPerson() {
      return this.person;
   }
   
   public void setPerson(Person person) {
      this.person = person;
   }
   
   private String password;
   
   public void setPassword(String value) {
      this.password = value;
   }
   
   public String getPassword() {
      return this.password;
   }
   
   private int roleID;

public void setRoleID(int value) {
    this.roleID = value;
}
@Id
public int getRoleID() {
    return this.roleID;
}
}
