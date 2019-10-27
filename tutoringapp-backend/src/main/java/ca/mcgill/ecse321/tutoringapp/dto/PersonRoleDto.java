package ca.mcgill.ecse321.tutoringapp.dto;

public class PersonRoleDto {
	
	private String password;
	private PersonDto person;
	
	public PersonRoleDto() {
	}
	
	public PersonRoleDto(String password) {
		this(password, null);
	}
	
	public PersonRoleDto(String password, PersonDto person) {
		this.password = password;
		this.person = person;
	}
	
	public String getPassword() {
		return password;
	}
	
	public PersonDto getPerson() {
		return person;
	}
	
	public void setPerson(PersonDto person) {
		this.person = person;
	}
	
}
