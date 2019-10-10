import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class Subject{
private String name;

public void setName(String value) {
this.name = value;
}
public String getName() {
return this.name;
}
   
   }
