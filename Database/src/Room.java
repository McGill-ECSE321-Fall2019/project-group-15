import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Room{
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
   
   /**
    * <pre>
    *           1..1     1..1
    * Room ------------------------> RoomType
    *           &lt;       type
    * </pre>
    */
   private RoomType type;
   
   public void setType(RoomType value) {
      this.type = value;
   }
   
   public RoomType getType() {
      return this.type;
   }
   
   }
