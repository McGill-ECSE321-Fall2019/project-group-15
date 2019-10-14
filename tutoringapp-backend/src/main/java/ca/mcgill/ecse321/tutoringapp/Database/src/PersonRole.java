package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class PersonRole{
private int roleID;

public void setRoleID(int value) {
this.roleID = value;
}
@Id
public int getRoleID() {
return this.roleID;
}
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
}
