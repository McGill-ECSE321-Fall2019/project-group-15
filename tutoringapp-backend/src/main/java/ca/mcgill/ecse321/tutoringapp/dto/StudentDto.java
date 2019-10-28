package ca.mcgill.ecse321.tutoringapp.dto;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;

public class StudentDto {
	
	private int id;
	private String password;
	private Person person;
	public StudentDto() {
		
	}
	
	public StudentDto(String password, Person person) {
		this.password = password;
		this.person = person;
	}
	
	public int getID() {
		return id;
	}
	
}
