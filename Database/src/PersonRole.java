import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class PersonRole{
   private Person user;
   
   @ManyToOne(optional=false)
   public Person getUser() {
      return this.user;
   }
   
   public void setUser(Person user) {
      this.user = user;
   }
   
   private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}
}
