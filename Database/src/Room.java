import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Room{
   private int capacity;

public void setCapacity(int value) {
    this.capacity = value;
}
public int getCapacity() {
    return this.capacity;
}
private String id;

public void setId(String value) {
    this.id = value;
}
public String getId() {
    return this.id;
}
   private Set<Session> session;
   
   @OneToMany(mappedBy="room" )
   public Set<Session> getSession() {
      return this.session;
   }
   
   public void setSession(Set<Session> sessions) {
      this.session = sessions;
   }
   
   }
