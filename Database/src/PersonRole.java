import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class PersonRole{
<<<<<<< HEAD
   private Person user;
   
   @ManyToOne(optional=false)
   public Person getUser() {
      return this.user;
   }
   
   public void setUser(Person user) {
      this.user = user;
=======
   private Person person;
   
   @ManyToOne(optional=false)
   public Person getPerson() {
      return this.person;
   }
   
   public void setPerson(Person person) {
      this.person = person;
>>>>>>> b17574b3506f3343c4ff5e0484a123048fb4944c
   }
   
   private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}
}
