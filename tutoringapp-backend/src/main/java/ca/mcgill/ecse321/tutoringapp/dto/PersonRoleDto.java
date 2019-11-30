package ca.mcgill.ecse321.tutoringapp.dto;

public class PersonRoleDto {
	
	private Integer roleID;
	private String password;
	private PersonDto person;
	
	public PersonRoleDto() {
	}
	
	public PersonRoleDto(Integer roleID) {
		this(roleID, null, null);
	}
	
	public PersonRoleDto(Integer roleID, String password, PersonDto person) {
		this.roleID = roleID;
		this.password = password;
		this.person = person;
	}
	
	public Integer getRoleID() {
		return roleID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public PersonDto getPerson() {
		return person;
	}
	
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPerson(PersonDto person) {
		this.person = person;
	}
	
}
