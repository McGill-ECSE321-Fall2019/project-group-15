package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Entity;

@Entity
public class School{
	private Set<Subject> subject;

	@OneToMany(mappedBy="school" )
	public Set<Subject> getSubject() {
		return this.subject;
	}

	public void setSubject(Set<Subject> subjects) {
		this.subject = subjects;
	}

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
	@Id
	public String getName() {
		return this.name;
	}

}
