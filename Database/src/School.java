import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Entity;

@Entity
public class School{
private SchoolType type;

public void setType(SchoolType value) {
this.type = value;
}
public SchoolType getType() {
return this.type;
}
private String name;

public void setName(String value) {
this.name = value;
}
public String getName() {
return this.name;
}
   
   }
