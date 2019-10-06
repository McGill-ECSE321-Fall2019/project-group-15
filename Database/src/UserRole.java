import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class UserRole{
   private User user;
   
   @ManyToOne(optional=false)
   public User getUser() {
      return this.user;
   }
   
   public void setUser(User user) {
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
