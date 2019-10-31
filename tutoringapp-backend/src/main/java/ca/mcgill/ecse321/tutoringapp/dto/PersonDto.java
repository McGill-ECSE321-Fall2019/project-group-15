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

	public PersonDto(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setPersonRoles (List<PersonRoleDto> personRoles) {
		this.personRoles = personRoles;
	}
	
	public List<PersonRoleDto> getPersonRoles() {
		return personRoles;
	}

}
