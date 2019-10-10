import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Room{
private RoomType type;
   
   public void setType(RoomType value) {
this.type = value;
    }
public RoomType getType() {
return this.type;
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

private boolean isAvailable;

public void setIsAvailable(boolean value) {
    this.isAvailable = value;
}
public boolean isIsAvailable() {
    return this.isAvailable;
}
}
