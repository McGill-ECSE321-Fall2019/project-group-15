package ca.mcgill.ecse321.tutoringapp.dto;

import java.util.Collections;
import java.util.List;

public class PersonDto {
	private String firstName;
	private String lastName;
	private String userName;
	private List<PersonRoleDto> personRoles;

	public PersonDto() {
	}
	
	@SuppressWarnings("unchecked")
	public PersonDto(String firstName, String lastName, String userName) {
		this(firstName, lastName, userName, Collections.EMPTY_LIST);
	}
	
	public PersonDto(String firstName, String lastName, String userName, List<PersonRoleDto> arrayList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.personRoles = arrayList;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public List<PersonRoleDto> getPersonRoles() {
		return personRoles;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPersonRoles(List<PersonRoleDto> personRoles) {
		this.personRoles = personRoles;
	}
	
}
