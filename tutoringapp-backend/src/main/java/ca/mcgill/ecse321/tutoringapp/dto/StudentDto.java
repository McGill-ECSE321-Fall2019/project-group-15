package ca.mcgill.ecse321.tutoringapp.dto;

public class StudentDto {
	
	private Integer id;
	private String password;
	private PersonDto person;
	
	public StudentDto() {
		
	}
	
	public StudentDto(String password, PersonDto person, Integer id) {
		this.password = password;
		this.person = person;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonDto getPerson() {
		return person;
	}

	public void setPerson(PersonDto person) {
		this.person = person;
	}
	
}
