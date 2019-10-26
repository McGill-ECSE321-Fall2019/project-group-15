package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Person{
	
	/*private int personID;
	
	public void setPersonID(int value) {
		this.personID = value;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getPersonID() {
		return this.personID;
	}*/
	
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
