package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Id;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Person{
	private String userName;

	public void setUserName(String value) {
		this.userName = value;
	}
	@Id
	public String getUserName() {
		return this.userName;
	}
	private Set<PersonRole> personRole;

	@OneToMany(mappedBy="person" )
	protected Set<PersonRole> getPersonRole() {
		return this.personRole;
	}

	protected void setPersonRole(Set<PersonRole> personRoles) {
		this.personRole = personRoles;
	}

	private String firstName;

	public void setFirstName(String value) {
		this.firstName = value;
	}
	public String getFirstName() {
		return this.firstName;
	}
	private String lastName;

	public void setLastName(String value) {
		this.lastName = value;
	}
	public String getLastName() {
		return this.lastName;
	}
}
