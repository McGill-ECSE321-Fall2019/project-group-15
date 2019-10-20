package ca.mcgill.ecse321.tutoringapp.Database.src;

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
private String name;

public void setName(String value) {
    this.name = value;
}
public String getName() {
    return this.name;
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
